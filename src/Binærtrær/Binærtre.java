package Binærtrær;

// <T> - behandler den generiske datatypen T (dvs ca alle datatyper) - bekreft
public class Binærtre<T> {
    public static void main(String[] args) {
        // test leggInn()
        Binærtre<String> btre = new Binærtre<>();
        // er ikke hele poenget at vi skal starter indeksering på 1 for at det skal funke med binærtall-navigasjon?
        // i så fall bør det vel være feilmelding på posisjon = 0 ?
        btre.leggInn(0, "x"); // felmedling test - ikke lov å legge inn på posisjon < 1
        btre.leggInn(1,"a"); // rot - i github står det 0, men det kan vel ikke stemme? treet vil ikke stemme om vi starter på 0
        btre.leggInn(3,"b");
        btre.leggInn(6,"c");
        // btre.leggInn(6, "d"); // feilmelding test - noden finnes alt
        btre.leggInn(7,"e");
        btre.leggInn(14,"f");
        btre.leggInn(15,"g");
        btre.leggInn(31,"h");
    }

    // node-klasse - definer hva en node er
    private class Node {
        Node venstre, høyre;
        T verdi;

        // konstruktør - verdi uten pekere
        public Node(T verdi) {
            this.verdi = verdi;
            // pekerne skal være null, i github skrives slik:
            // this(verdi, null, null);
        }

        // konstruktør - sett verdi og pekere
        public Node(T verdi, Node venstre, Node høyre) {
            this.verdi = verdi;
            this.venstre = venstre;
            this.høyre = høyre;
        }
    }

    // utenfor node-klassen nå

    // lag rotnode, sett til null til å begynne med
    // hvorfor kan jeg skrive det på denne måten? og ikke Node<T> rot = New Node();
    Node rot = null;

    // leggInn-funksjon - legg inn gitt verdi på gitt posisjon
    // tror det egt bør være boolean så vi får en true/false avhengig av om det funket
    public void leggInn(int posisjon, T verdi) {

        if (posisjon <= 0) { // Sof: lagt inn selv - skal vi ikke starte på indeks 1?
            throw new IllegalArgumentException("Ikke lov å legge inn på indeks 0 eller mindre, treet starter på indeks 1.");
        }

        // vi kan "oversette" posisjonen til binærtall - vi kan bruke 0-ene og 1-erne som
        // navigasjon - den første 1 betyr gå inn i roten, og derfra forteller 1 at vi skal til høyre, mens 0 sier vi skal et steg til venstre
        // bruk metode for å automatisk oversette posisjon til binærtall - legg inn i char array
        char[] binærtall = Integer.toBinaryString(posisjon).toCharArray(); // parser til Integer, binærtall og direkte inn i char arrayet

        // pekere - p er current, q er foreldrenoden
        Node p = rot;
        Node q = null; // når vi er i rot er det ingen foreldrenode

        // loop - følg navigasjon i charArray for å komme på rett posisjon - sjekk om den er ledig
        for (int i = 1; i < binærtall.length; i++) { // i binærtrær starter vi indeksering på 1 - blir lettere matematisk
            // System.out.println("Steg " + i + ": " + binærtall[i]);

            q = p; // sett q til å peke der vi er nå

            if (p == null) { // hvis p's indeks er null vi ikke på en eksisterende indeks, da kan vi ikke iterere
                throw new IllegalArgumentException("Ulovlig indeks: mangler node på vei til posisjon " + posisjon);
            }
            if (binærtall[i] == '0') {
                // ta et steg til venster (dvs følg venstrepekeren)
                p = p.venstre;
            } else {
                // hvis ikke 0, må det være 1 og vi skal et steg til høyre
                p = p.høyre;
            }
            // vi har allerede satt q til å være p, så foreldrepekeren er oppdatert
        }

        // vi er nå på rett indeks - nå må vi sjekke om det er plass
        // det skal ikke ligge noen node der fra før
        if (p != null) {
            throw new IllegalArgumentException("Allerede noe lagret på posisjon " + posisjon);
        }

        // hvis det er ledig er vi teknisk sett ute av treet (indexOutOfBounds)
        // vi lager en ny node med verdien der p peker -> ikke lenger out of bounds
        p = new Node(verdi);

        // hvis q er null vet vi at dette må være rotnoden, for den er den eneste uten forelder
        if (q == null) {
            rot = p;
            // dersom siste element i char array er 0 skal vi legge inn som venstrebarn
        } else if (binærtall[binærtall.length - 1] == '0') {
            q.venstre = p; // foreldrenodens venstrebarn blir p
        } // hvis ikke  (dvs siste tall er 1) skal det være høyrebarn
        else {
            q.høyre = p; // foreldrenodens høyrebarn blir p
        }

        // for spesielt interesserte: Rekursiv innlegging
    }


}
