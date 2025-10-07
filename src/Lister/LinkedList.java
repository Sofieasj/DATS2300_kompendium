package Lister;

// Liste<T> ligger under ArrayList-klassen
public class LinkedList<T> implements Liste<T> {

    // Lag noder!
    private class Node<T> {
        T verdi;
        Node<T> neste;

        // konstruktør - legg inn verdi
        public Node(T verdi) {
            this.verdi = verdi;
        }

        // konstruktør nr 2 - legg inn verdi OG ??
        public Node(T verdi, Node<T> neste) {
            this.verdi = verdi;
            this.neste = neste;
        }

        // sjekk om en node inneholder en gitt verdi
        public boolean inneholder(T verdi) {
            if (this.verdi.equals(verdi)) { // hvis verdien finnes
                return true;
            }
            if (neste == null) { // dersom det ikke finnes noen neste node
                return false;
            }
            return neste.inneholder(verdi); // ????
        }
    }

    // ut av Node-klassen ( i LinkedList-klassen
    Node<T> hode;

    // konstruktør - hode
    public LinkedList() {
        hode = null;
    }

    // arvede metoder fra Beholder og Liste
    @Override
    public boolean leggInn(int indeks, T t) {
        return false;
    }

    @Override
    public T hent(int indeks) {
        return null;
    }

    @Override
    public T oppdater(int indeks, T t) {
        return null;
    }

    @Override
    public boolean fjern(int indeks) {
        return false;
    }

    @Override
    public int indeksTil(T t) {
        return 0;
    }

    @Override
    public boolean leggInn(T t) {
        return false;
    }

    @Override
    public boolean fjern(T t) {
        return false;
    }

    @Override
    public int antall() {
        return 0;
    }

    @Override
    public boolean tom() {
        return false;
    }

    @Override
    public boolean inneholder(T t) {
        return false;
    }

    @Override
    public void nullstill() {

    }
}