package Sorterings_algoritmer;

//https://www.baeldung.com/java-merge-sort

public class MergeSort {
    // tar inn array + lengden på (del)arrayet (n)
    public static void mergeSort(int[] a, int n) {
        // base case - det er mindre enn 2 elementer, arrayet kan ikke deles mer
        if (n < 2) {
            return;
        }
        int mid = n / 2; // halver arrayet - splitt i to
        int[] l = new int[mid]; // 1. halvdel med lengde mid (100/2 = 50)
        int[] r = new int[n - mid]; // 2. halvdel med lengde n(total lengde)-mid (resterende halvdel)

        //iterer gjennom - sett verdiene fra hver halvdel inn i hvert sitt array
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        // reqursion - kall på 1 array, lengde mid + 2 array, lengde n-mid
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        // kall sorteringsalgoritmen - den returnerer minste element først (med det trenger ikke jeg)
        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        // definer tellere for loopene
        int i = 0, j = 0, k = 0;

        // sjekk at det ikke er indexOutOfBounds (?)
        while (i < left && j < right) {
            if (l[i] <= r[j]) { // hvis l er mindre enn r, legg inn l i resultat-array
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++]; // hvis r er mindre enn l, legg inn i a array
            }
        }
        while (i < left) { // hva skjer her - er det i tilfelle en av sidene "mangler"?
            a[k++] = l[i++];
        }
        while (j < right) { // hva skjer her - hvis ikke det er noe på venstre side?
            a[k++] = r[j++];
        }
    }
}
