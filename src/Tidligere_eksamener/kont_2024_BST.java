package Tidligere_eksamener;

import java.util.Comparator;

public class kont_2024_BST {
    public static void main(String[] args) {
        BinærSøkeTre<Integer> bst = new BinærSøkeTre<>(Comparator.naturalOrder(), 10); // rot-verdi
        // legg inn flere noder
        bst.leggInn(2);
        bst.leggInn(6);
        bst.leggInn(4);
        bst.leggInn(10);
        bst.leggInn(8);

        // sjekk - hva inneholder treet
        System.out.println(bst.inneholder(10));
        System.out.println(bst.inneholder(1));
    }

    // Lag en leggInn() funksjon for denne klassen - har ingen Nodeklasse, hver node er en instansering av BST-klassen
    static class BinærSøkeTre<T> {
        private BinærSøkeTre<T> venstre, høyre = null;
        private Comparator<T> comp;
        private T verdi;

        // Konstruktør - hvorfor har den comp?
        public BinærSøkeTre(Comparator<T> comp, T verdi) {
            this.verdi = verdi;
            this.comp = comp;
        }
        public boolean inneholder(T verdi) {
            int cV = comp.compare(verdi, this.verdi);
            if (cV == 0) {
                return true;
            } else if (cV < 0) {
                return this.venstre != null && this.venstre.inneholder(verdi);
            } else {
                return this.høyre != null && this.høyre.inneholder(verdi);
            }
        }
        public void leggInn(T verdi) {
            //null-sjekk - ingenting å gjøre dersom verdien er null
            if (verdi == null) return;

            // base case? blir ikke den egt inni if-ene - dersom this.x == null, så legger vi bare inn og er ferdige

            BinærSøkeTre ny = new BinærSøkeTre(comp, verdi); // instansier ny node

            // traverser - finn ut hvor den skal ligge - rekursivt
            // er det ledig eller må vi gå lengre?

            // fordi vi instansiere treet for å kunne kalle denne, må det settes en rotverdi først, mener derfor det ikke trengs
            // å håndteres at vi legger inn den første verdien og at den skal være rot, ser også av BST-klassen at det ikke er en rot-peker å evt oppdatere

            int cV = comp.compare(verdi, this.verdi);
            // skal vi gå til høyre eller venstre?
            if (cV < 0) { // gå til venstre < 0
                if (this.venstre == null) {
                    this.venstre = ny; // det er ledig - legg inn verdi
                    System.out.println(verdi); // debugging - print verdien som ble lagt inn
                }
                else {
                    this.venstre.leggInn(verdi); // det er ikke ledig - kall funksjonen på nytt og let videre
                }
            } else { // gå til høyre >= 0
                if (this.høyre == null) {
                    this.høyre = ny; // det er ledig - legg inn verdi
                    System.out.println(verdi); // debugging - print verdien som ble lagt inn
                }
                else {
                    this.høyre.leggInn(verdi); // ikke ledig - kall funksjon på nytt fra dette punktet og let videre
                }
            }
        }
    }
}
