package Sorterings_algoritmer;

// Choose a value in the array to be the pivot element.
// Order the rest of the array so that lower values than the pivot element are on the left, and higher values are on the right.
// Swap the pivot element with the first element of the higher values so that the pivot element lands in between the lower and higher values.
// Do the same operations (recursively) for the sub-arrays on the left and right side of the pivot element.

public class kvikkSorter {
    // partisjoner - velg pivot og del arrayet i to flere ganger
    // kall rekursiv funksjon - kall seg selv repetetivt

    public static void kvikkSorter (int[] a, int til, int fra) {
        int v = fra;
        int h = til;
        int p = a[til];

        while (v < h) {
            while (v < h && a[v] < p) {
                v++;
            }
            while (v > h && a[h] > p) {
                h--;
            }

            if (v < h) {
                bytt(a, v, h);
            }
        }
        bytt(a, v, p);


    }

    public static void partisjoner (int[] a) {
        int n = a.length;
        int p = a[n - 1]; // velger bakerste element som pivot
        int v = a[0]; // venstrepeker
        int h = a[n-2]; // høyrepeker

        while( v <= h) {
            // fordi vi vil kjøre inntil vi finner kandidater for bytte bruker vi while-løkker
            while (v < p) {
                v++; // vi går simpelten videre til neste verdi og ser på den
            }
            while (h >= p) {
                h--; // vi går videre (bakover) og ser på neste verdi
            }
            // dersom vi har funnet kandidat for v og h (v > enn p og h < enn p)
            bytt(a, v, h);
            v++; // flytt pekerne
            h--;
        }
    }

    //kall sorteringsfunksjon
    // sorter verdiene på hver side av pivot
    public static void sorter(int[] a, int v, int h) {
        // base case - dersom v og h er på samme element, eller har krysset hverandre
        if (v >= h) {
            return;
        }

    }

    // hjelpemetode - bytt verdiene på a[v] og a[h]
    public static void bytt (int[] a, int v, int h) {
        int tmp = a[v];
        a[v] = a[h];
        a[h] = tmp;
    }
}
