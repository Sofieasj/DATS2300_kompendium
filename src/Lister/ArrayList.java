package Lister;

public class ArrayList {}

// interface - klasser som implementerer må ha metodene herfra
interface Beholder<T> {
    boolean leggInn(T t);
    boolean fjern(T t);
    int antall();
    boolean tom();
    boolean inneholder(T t);
    void nullstill();
}

// extender Beholder - dvs klasser som implementerer må ha metodene herfra OG fra beholder ettersom den blir extended
interface Liste<T> extends Beholder<T> {
    boolean leggInn(int indeks, T t);
    T hent(int indeks);  // returnerer et element av typen T
    T oppdater(int indeks, T t);  // returnerer et element av typen T
    boolean fjern(int indeks);
    int indeksTil(T t);
}

// implementerer Liste, som extender Beholder - må implementere alle metodene
class TabellListe<T> implements Liste<T> {
    // definer variabler for klassen
    private T[] tabell; // nytt array, holder typen T
    private int antall; // antall elementer i []
    private int kapasitet; // [] sin kapasitet (maks)

    // konstruktør som kaller *den andre konstruktøren* med (10) som argument
    // dvs - hvis du oppretter uten å spesifisere kapasitet blir dette satt som standard
    public TabellListe() { // "standard" - forhåndsdefinert str
        this(10);
    }

    // konstruktør - send inn kapasitet og opprett array - kalles av foregående konstruktør hvis man ikke oppgir kapasitet
    public TabellListe(int kapasitet) { // gir fleksibilitet å kunne definere str selv
        this.kapasitet = kapasitet;
        // java kan ikke direkte opprette generisk array -> derfor Object som castes til T[]
        tabell = (T[]) new Object[kapasitet];
        antall = 0;
    }

    // utvide tabbellen - når et array fylles opp, lag nytt (større) og kopier over
    private void utvidTabell() {
        kapasitet = 2 * kapasitet;
        T[] tmp = (T[]) new Object[kapasitet]; // opprett temp array for å kopiere over (med ny str) - caster til T[]
        // [] som kopieres, fra posisjon, [] det kopieres til, startposisjon der, antall elementer som skal kopieres (alle)
        System.arraycopy(tabell, 0, tmp, 0, antall);
        tabell = tmp; // setter tmp som ny verdie/innhold for tabell - dvs med oppdatert str
    }

    // sjekk om det er en lovlig indeks å legge inn på
    // boolean leggInn returnerer om vi skal legge inn (true) eller hente ut (false)
    private void sjekkIndeks(int indeks, boolean leggInn) {
        // om leggInn true, indeks er >= 0 og <= antall elementer
        // antall - vi har 5 elementer, skal legge inn 6., siden a[] starter på indeks 0 kan vi legge det inn på plass 5 (tilsvarer antallet)
        if(leggInn && indeks >= 0 && indeks <= antall) {
            return;
        }
        // legginn false, indeks >= 0 og indeks < totalt antall (fordi i starter på 0 (n-1) - 5 elementer ligger på 0-4)
        if (indeks >= 0 && indeks < antall) {
            return;
        }
        // else-case - kast feilmelding for ugyldig indeks
        throw new IndexOutOfBoundsException("Ulovlig indeks.");
    }

    // METODER FRA INTERFACE BEHOLDER
    @Override
    public boolean leggInn(int indeks, T t) {
        // kall sjekkindeks() - sjekk om lovlig indeks, true for leggInn fordi det er det vi forsøker
        sjekkIndeks(indeks, true);
        // dersom antall elementer == arrayets kapasitet -> utvid
        if(antall == kapasitet) {
            utvidTabell();
        }
        // iterer fra siste - sett [i] som verdi for den foregående (pga revers)
        for (int i = antall-1; i >= indeks; i--) {
            tabell[i+1] = tabell[i];
        }
        // sett t som verdi på a[i], øk antall elementer, returner at det gikk (true)
        tabell[indeks] = t;
        antall++;
        return true;
    }

    @Override
    public T hent(int indeks) {
        // sjekk at det er lovlig indeks, false fordi vi henter, ikke legger inn
        sjekkIndeks(indeks, false);
        // returner innholdet på indeksen
        return tabell[indeks];
    }

    @Override
    public T oppdater(int indeks, T t) {
        // lag tmp hjelpevariabel
        T tmp = tabell[indeks];
        // legg ny verdi inn på indeksen - tmp sitt innhold oppdateres
        tabell[indeks] = t;
        // returner ny verdi (oppdatert)
        return tmp;
    }

    // gjør selv
    @Override
    public boolean fjern(int indeks) {
        return false;
    }

    // gjør selv
    @Override
    public int indeksTil(T t) {
        return 0;
    }

    // METODER FRA INTERFACE LISTE

    @Override
    public boolean leggInn(T t) {
        // dersom arrayet er fullt - utvid
        if(antall == kapasitet) {
            utvidTabell();
        }
        // else? - legger t-verdi inn på t[a] og øk a (etterpå)
        tabell[antall++] = t;
        return true;
    }

    @Override
    public boolean fjern(T t) {
        return false;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return (antall == 0);
    }

    // sjekk om den inneholder en gitt verdi - true/false
    @Override
    public boolean inneholder(T t) {
        // iterer gjennom
        for(int i = 0; i < antall; i++) {
            // sjekk om verdien på i == t
            if(tabell[i] == t) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void nullstill() {
        // hardcoder reset
        kapasitet = 10;
        antall = 0;
        tabell = (T[]) new Object[kapasitet];
    }
}
