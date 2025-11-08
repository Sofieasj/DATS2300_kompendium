package Hashing;

import org.w3c.dom.Node;

public class Hashing {
    public static void main(String[] args) {

    }
}

// INTERFACE MAP - key og value
interface Map<N, V> {
    // av typen V (verdi)
    public V leggInn(N nøkkel, V verdi);
    public V fjern(N nøkkel);
    public V hent(N nøkkel);
}


//  INTERFACE SET - kun key (unike)
interface Set<V> { // hvorfor er det V og ikke N?
    // hvorfor er det boolean her
    public boolean leggInn(V verdi);
    public boolean fjern(V verdi);
    public boolean inneholder(V verdi);
}

class HashSet<V> implements Set<V> {
    // set bruker hashmap internt - key i hm blir Value her, mens value i hm blir et dummy-obj - vi skal ikke noe med det
    HashMap<V, Object> hm;
    Object obj = new Object(); // dummy

    // konstruktør
    public HashSet() {
        hm = new HashMap<>(500); // antall indekser i array?
    }

    @Override
    public boolean leggInn(V verdi) {
        // vi må sjekke om verdien alt finnes - da skal vi ignorere den
        // hvis ikke lager vi et objekt og legger verdien inn

        if(hm.hent(verdi) != null) { // det er alt en verdi her
            return false; // false - vi legger ikke inn duplicate value
        } else {
            // det er plass - vi legger inn nytt objekt med innsendt verdi
            hm.leggInn(verdi, obj);
            return true;
        }
    }

    @Override
    public boolean fjern(V verdi) {
        return hm.fjern(verdi) != null; // true dersom !=, ellers false
        // short form (compact return condition) for:
//        if (hm.hent(verdi) != null) {
//            return true;
//        } else {
//            return false;
//        }
    }

    @Override
    public boolean inneholder(V verdi) {
        // compact return condition - returns true if != null, else return false
        return hm.hent(verdi) != null;
    }
}

class HashMap<N, V> implements Map<N, V> {

    // Node-klasse
    private class node {
        N nøkkel;
        V verdi;
        Node neste;

        // konstruktør - node
        public Node(N nøkkel, V verdi, Node neste) {
            this.nøkkel = nøkkel;
            this.verdi = verdi;
            this.neste = neste;
        }
    }

    Node[] liste; // deklarerer et array med noder (linkedlist på hver index)
    int størrelse; // størrelsen på hash tabellen (arrayet)

    // konstruktør - hashmap
    public HashMap(int størrelse) {
        this.størrelse = størrelse; // str på mappet []
        liste = (Node[]) new Object[størrelse]; // et array med objekter,med gitt str, som vi caster til Node[] type
        // chat sier det over er feil - gjør dette:
        liste = (Node[]) new Node[størrelse];
    }

    // beregn indeks basert på hash value
    private int beregnPosisjon(int hashVerdi) {
        int pos = hashVerdi % størrelse;
        if (pos < 0 ) {
            pos = størrelse + pos;
        }
        return pos;
    }

    @Override
    public V leggInn(N nøkkel, V verdi) {
        return null;
    }

    @Override
    public V fjern(N nøkkel) {
        return null;
    }

    @Override
    public V hent(N nøkkel) {
        return null;
    }
}
