package Lister;

import java.util.NoSuchElementException;

// pga implements må vi ta med alle funksjoner fra Liste (og Beholder)
public class Singly_LinkedList <T> implements Liste <T> {
    private class Node<T> { // kan være av ulike datatyper T
        T verdi; // verdien i noden
        Node<T> next; // peker - setter det til type Node<T>

        // konstruktør - legg inn verdi, next peker ikke på noe (legg inn til sist)
        public Node(T verdi) {
            this.verdi = verdi;
            next = null;
        }

        // konstruktør - legg inn verdi og peker på neste (legg inn først/midt i)
        public Node(T verdi, Node<T> next) {
            this.verdi = verdi;
            next = next;
        }

        // rekursiv metode - sjekker listen for om den inneholder en gitt verdi
        // hvorfor finnes denne både her og lengre nede i den ytre klassen?
        public boolean inneholder(T verdi) {
            // hvis den innsendte verdien matcher verdien i denne noden
            if (this.verdi.equals(verdi)) {
                return true;
            }
            // sjekk om det ikke finnes flere noder
            if (next == null) {
                return false;
            }
            // rekursjon! sjekker hva resten av listen inneholder ved å kalle next
            return next.inneholder(verdi);
        }
    }

    Node<T> head; // startpunktet for listen
    // konstruktør for hode
    public Singly_LinkedList () {
        head = null;
    }

    // METODER FRA LISTE INTERFACE

    @Override
    public boolean leggInn(int indeks, T t) { // legg inn på gitt indeks
        // lag selv:
        // sjekk lovlig indeks: linkedlist er sekvensielle - kan ikke skippe elementer og legg til på en plass langt utenfor lista
        sjekkIndeks(indeks, true);
        // lag en ny node - kall konstruktør som oppretter midt i
        Node<T> ny = new Node<T>(t, peker); // konstruktør - send inn data og noden den skal peke på (next)
            // pekere må tilpasses
            // legg inn verdien
        return false;
    }

    public boolean sjekkIndeks(int indeks, boolean leggInn) {
        // sjekk om indeksen eksisterer i listen
        Node<T> current = head; // start i hode

        // hvis vi skal legge inn - boolean leggInn == true
        if (leggInn) {
            // sjekk at indeks ikke er mer enn 1 større enn antall - returnerer true om statement er sann
            // vi legge inn inni eller på slutten
            return indeks >= 0 && indeks <= antall();
        } else {
            // hvis vi bare skal sjekke/hente - boolean leggInn == false
            // sjekk at indeks er mindre eller lik antall elementer
            // antar at liste også starter på indeks 0, derfor vil det være 1 mindre indeks enn antall (dvs med 10 elementer er indeks 10 ledig)
            return indeks >= 0 && indeks < antall();
        }
    }

    @Override
    public T hent(int indeks) { // hent basert på indeks (ikke verdi)
        // sjekk om det er lovlig indeks - lag og kall metode
        // false fordi vi vil hente, ikke legge inn
        sjekkIndeks(indeks, false);

        // sett startpunkt current til å være hode
        Node<T> current = head;
        // iterer så lenge i er mindre enn indeksen vi leter etter
        for (int i = 0; i < indeks; i++) {
            current = current.next; // sett neste element til å være current
        }
        return current.verdi; // returner verdien i current med vår indeks
    }

    @Override
    public T oppdater(int indeks, T t) { // oppdater på angitt indeks, til innsendt verdi
        // sjekk lovlig indeks - hvis ikke send feilmelding
        if(!sjekkIndeks(indeks, false)) { // false - vi skal oppdatere en eksisterende, ikke legge til ny
            throw new IndexOutOfBoundsException("Kan ikke oppdatere, ulovlig indeks");
        }
        Node<T> current = head; // sett startpunkt til head
        for (int i = 0; i < indeks; i++) { // loop fram til den spesifiserte indeksen - NB vær sikker på at du faktisk kommer dit, og ikke stopper en før
            current = current.next; // flytt peker til neste node
        }
        T oldValue = current.verdi; // lagre gammel verdi i hjelpevariabel
        current.verdi = t; // sett ny verdi
        return oldValue; // returner den gamle verdien så vi vet hva vi har fjernet
    }

    @Override
    public boolean fjern(int indeks) { // fjern node basert på indeks
        if(!sjekkIndeks(indeks, false)) { // false - vi skal fjerne en eksisterende, ikke legge til ny
            throw new IndexOutOfBoundsException("Kan ikke fjerne, ulovlig indeks");
        }
        Node<T> current = head; // sett startpunkt til head
        Node<T> prev = null; // hold styr på forrige node

        // iterer til vi finner indeksen (for-loop som i sjekkIndeks()
        for (int i = 0; i < indeks; i++) { // loop fram til den spesifiserte indeksen - NB vær sikker på at du faktisk kommer dit, og ikke stopper en før
            current = current.next; // flytt peker til neste node
        }
        // "fjern" noden ved å bytte pekeren til den forrige noden, og å sette egen peker til null
        if (current == head) { // dersom det er hode-noden
            head = current.next; // vi "fjerner" hodet ved å sette hodeverdien til å peke på neste element
            // for å beskytte sensitiv info bør informasjonen slettes helt
        }
        else {
            prev.next = current.next; // vi setter forrige til å peke på den neste, dvs ingenting peker på den vi er i, og den "forsvinner"
        }
        // god praksis: fullstendig fjern koblingen mellom den "fjernede node" og de andre
        current.next = null; // sett peker til null
        return true; // prosessen er ferdig
    }

    @Override
    public int indeksTil(T t) { // finn indeksen til et gitt element
        // sjekk at det ikke er tom liste - da er det ikke noe vits å gjøre noe mer
        if (tom()) {
            throw new NoSuchElementException("Tom liste");
        } else {
            // jeg kunne kalle inneholder(t t) for å sjekke om verdien finnes - men jeg må allikevel iterere her, så blir dobbelt opp
            Node<T> current = head; // startsted
            int indeks = 0; // sett startverdi for indeksen

            while (current != null) {
                if (current.verdi.equals(t)) { // dersom verdien matcher den noden vi ser på nå
                    return indeks;  // returner posisjonen vi er på
                } else {
                    // hvis verdiene ikke matcher, gå til neste node og øk indek
                    current = current.next;
                    indeks++;
                }
            }
            // hvis vi aldri fant verdien:
            throw new NoSuchElementException("Verdien finnes ikke i listen.");
        }
    }

    // METODER FRA BEHOLDER INTERFACE

    @Override
    public boolean leggInn(T t) { // legg inn i starten - spør kun om verdi
        head = new Node<>(t, head); // setter hode til å være ny node med innsendt verdi, peker på forrige hode (?)
        return true; // fullført
    }

    @Override
    public boolean fjern(T t) { // fjern noden med innsendt verdi
        Node<T> current = head; // sett hode som der vi starter
        Node<T> prev = null; // holder styr på forrige node. Settes til NULL, vi er i head (ingen forrige)

        // så lenge current ikke er null, dvs det fremdeles er flere elementer
        while (current != null) {
            if (current.verdi.equals(t)) { // sjekk om innsendt verdi matcher den i noden - isåfall skal vi fjerne
                if (current == head) { // dersom det er hode-noden
                    head = current.next; // vi "fjerner" hodet ved å sette hodeverdien til å peke på neste element
                    // for å beskytte sensitiv info bør informasjonen slettes helt
                }
                else {
                    prev.next = current.next; // vi setter forrige til å peke på den neste, dvs ingenting peker på den vi er i, og den "forsvinner"
                }
                // god praksis: fullstendig fjern koblingen mellom den "fjernede node" og de andre
                current.next = null; // sett peker til null
                return true; // prosessen er ferdig
            }
            // dersom vi ikke gikk inn i if() og fjernet verdien, gå videre i lista
            prev = current; // vi setter forrige til å holde current (nårværende)
            current = current.next; // vi setter den neste i rekken til å være nåværende verdi
        }
        return false; // dersom vi ikke fant noen som matchet innsendt verdi
    }

    @Override
    public int antall() { // returnerer antall noder i listen
        int ant = 0; // startverdi

        Node<T> current = head; // vi starter telling fra hode
        // iterer gjennom så lenge det er flere elementer
        while (current != null) {
            ant++; // øk teller (antall elementer)
            current = current.next; // flytt current-peker til neste element
        }
        return ant;
    }

    @Override
    public boolean tom() { // dersom hode er null vet vi at listen er tom
        // returnerer true/false avhengig av om head == null
        // som om vi skrev if-else
        return (head == null);
    }

    @Override
    public boolean inneholder(T t) { // sjekk om en gitt verdi finnes
        // sjekk om listen er tom - isåfall vet vi den ikke finnes
        if (tom()) {
            return false;
        }
        // skjønner ikke hva som er poenget, men vi sjekker om lista er tom
        // hvis ikke kalles den rekursive inneholder(T verdi)-funksjonen i Node-klassen
        // den returnerer true/false basert på om verdien finnes eller ei
        return head.inneholder(t); // hvorfor er det * head *.inneholder() ?
    }

    @Override
    public void nullstill() { // tilbakestill hele listen (slett)
        head = null;
        // NB dette er teknisk sett en dårlig løsning, verdiene finnes fortsatt, vi kan bare ikke aksessere dem
        // risiko dersom det er sensitiv informasjon - verdiene burde slettes
    }
}
