package Sorterings_algoritmer;

// Alltid O(n log n) - uavhengig av best/worst/avg case - fordi vi deler opp alt, sorterer og så fletter sammen igjen
// halveringen er O(log n) og sammenflettingen er O(n) -> O(n log n), litt verre enn O(n), men bedre enn O(n^2)

// vi halverer arrayet gjentatte ganger inntil hvert array er kun 1 element langt
// så fletter vi rekursivt sammen igjen, nivå for nivå, og sorterer hvert nivå som flettes

// vi har en int[] metode som tar inn et array
// en basecase - om det er 1 eller færre elementer i arrayet
// finner lengden og oppretter et v og et h array med halve lengden hver
// via for loop legges verdiene i []a inn i disse (en halvdel i hver)
// vi setter v og h til å være mergesort(v) og mergesort(h) - altså rekursive kall - disse vil repetere inntil base case
// deretter kalles merge-funksjonen, via return, som sorterer og fletter sammen igjen arrayet

// merge tar inn v og h []
// lager et resultatarray med lengde v+h, og indekstellere for alle arrayene til bruk i while-løkker
// først - while det er elementer i v og h - sammenligner med if og legger den minste av de to inn i resultat-array
// dersom ett array er tomt legges de resterende fra det andre inn i resultat, som så returneres


public class MergeSort {
    public static void main(String[] args) {
        int[] a = {1, 4, 3, 6, 2, 7, 9, 5, 6, 2};
        int[] sortert = mergeSort(a);
        for(int i : sortert) {
            System.out.print(i + " ");
        }
    }

    public static int[] mergeSort (int[] a) {
        // sjekk - for kort/tomt array + base case!
        if (a.length <= 1) return a;

        int n = a.length; // total array-lengde
        // halver array inntil det kun er 1 element i hvert array
        int mid = n / 2; // finn midtpunktet
        int[] v = new int[mid]; // like langt som første halvdel av []a
        int[] h = new int[n - mid]; // like langt som []a, minus den første halvdelen (pga heltallsdivisjon vi ikke bare kan skrive mid?)

        // iterer - flytt verdiene manuelt over i hver sine arrays
        // venstre array - start fra start og kjør til midtpunkt (IKKE inkludert)
        for (int i = 0; i < mid; i++) {
            v[i] = a[i];
        }

        // høyre array, start fra midpunkt og kjør til slutten av arrayet
        for (int i = mid; i < n; i++) {
            h[i-mid] = a[i];
        }

        // rekursivt kall - sorter inntil vi oppnår base case (n <= 1)
        v = mergeSort(v);
        h = mergeSort(h);

        // etter base case - kall sortering og merge
        return merge(v, h);
    }

    // ta inn v og h del-array
    public static int[] merge(int[] v, int[] h) {
        int[] resultat = new int [v.length + h.length]; // nytt array for resultatet, med plass til alle elementer
        int i = 0, j = 0, k = 0; // tellere for while-loopene

        // så lenge begge array fremdeles har elementer
        while (i < v.length && j < h.length) {
            // dersom v er mindre enn h, legger vi v-verdien inn i resultat
            if (v[i] < h[j]) {
                resultat[k++] = v[i++]; // vi legger inn og flytter pekerne i samme operasjon
            } else { // alternativt legger vi h-verdien inn i resultat
                resultat[k++] = h[j++];
            }
            // kortform if-else: resultat[k++] = (a[i] < b[j]) ? a[i++] : b[j++];
        }

        // etter at ett array tømt kan det fremdeles være elementer i det andre arrayet - vi kopierer disse over
        while (i < v.length) {
            resultat[k++] = v[i++];
        }
        while (j < h.length) {
            resultat[k++] = h[j++];
        }
        return resultat; // ferdigsortert tabell
    }

}
