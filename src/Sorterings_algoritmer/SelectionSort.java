package Sorterings_algoritmer;

// O(n^2) - uavhengig av case - hele arrayet må gjennomsøkes for å finne minste verdi
// i denne implementasjonen: sorter har en loop, og inni denne
// kalles min() som også har en loop -> nestede loops

// vi går gjennom arrayet igjen og igjen (n ganger), finner og flytter den
// laveste verdien til rett før den usorterte delen av arrayet begynner
// vi gjentar inntil arrayet er sortert
// vi sorterer en og en verdi

public class SelectionSort {
    public static void main(String[] args) {
        int [] a = {4, 6, 3, 1, 7, 6, 4, 9};
        sorter(a);
        for(int i : a) {
            System.out.print(i + " ");
        }
    }

    static void sorter (int [] a) {
        int minstePosisjon;

        // vi iterer gjennom hele arrayet - finner minste verdi
        for (int i = 0; i < a.length-1; i++) {
            // vi kaller vår min()-funskjon - finner minste verdi i arrayet
            minstePosisjon = minIndeks(a, i, a.length); // minste verdi lagres
            // vi kaller vår bytt - switcher i og minste verdi
            bytt(a, i, minstePosisjon);
        }
    }

    // vi lager en funksjon for å finne indeksen til misnte verdi
    public static int minIndeks(int[] a, int fra, int til) {
        // sjekk for ulovlige verdier
        if (fra > til || fra < 0 || til > a.length) {
            throw new IllegalArgumentException("til-verdien må være større enn fra-verdien, og fra må være større enn 0");
        }

        int min = fra; // indeksen fra (IKKE verdien a[fra])
        for (int i = fra+1; i < til; i++) { // til og fra blir vår start og stopp - NB vi inkluderer IKKE til-verdien
            if (a[i] < a[min]) { // dersom i er mindre enn minste
                min = i; // oppdater *indeksen* (ikke verdien)
            }
        }
        return min; // returner minste INDEKS
    }

    // vi bytter verdiene a[i] og a[j] vha en hjelpevariabel
    public static void bytt(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
