package Binærtrær;

import Generiske_algoritmer.Beholder;

// Binærsøketre, implementerer den generiske metoden Beholder (under Beneriske_algoritmer)
public class BST <T> implements Beholder {

    // Node-klasse
    public class Node {
        int verdi;
        Node v, h, p, q; // alle pekerne

        // konstruktør - bladnode, pekere satt til null
        public Node (int verdi) {
            this.verdi = verdi;
            this.v = null;
            this.h = null;
            this.p = null;
            this.q = null;
        }
    }

    // Legg inn
    public static boolean leggInn (T verdi) {
        return true;
    }

    // Søk / Inneholder

    // Fjern
}
