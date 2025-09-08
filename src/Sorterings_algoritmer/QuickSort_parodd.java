package Sorterings_algoritmer;

import java.util.Arrays;

// sorter en tabell i to deler -> oddetall til v og partall til h
// ikke bruk hjelpetabell, kun hjelpevariabel
// sorter hver del i stigende rekkefølge
public class QuickSort_parodd {

    public static int[] parterParOdd(int[] a) {
        // definer variabler - pekere
        int v = 0;
        int h = a.length - 1;

        // segreger oddetall og partall
        // gå gjennom hele arrayet, så lenge pekerne ikke krysser hverandre
        while (v < h) {
            // sjekk fra venstre - øk så lenge det er oddetall ( != 0 og ikke = 1 fordi det kan være negative tall)
            // HVORFOR skal det også sjekkes for v < h verdi?
            while(a[v] % 2 != 0) {
                v++;
            }
            // sjekk fra høyre - øk så lenge det er partall
            while(a[h] % 2 == 0) {
                h--;
            }

            // dersom begge while looper blir usanne, har vi 2 kandidater - disse skal nå bytte plass:
            // ta med en ny sjekk av v < h, så det ikke blir en feilaktig siste flip
            if(v <= h) {
                int temp = a[v];
                a[v] = a[h];
                a[h] = temp;
            }
        }
        return a;
    }

    // SORTER ARRAYET STIGENDE, MEN BEHOLD ODDETALL TIL VENSTRE OG PARTALL TIL HØYRE
    public static void quickSort(int[] a, int start, int slutt) {
        // base case - hvis sluttindex <= startindex er det 0-1 element igjen
        if(slutt <= start) {
            return;
        }

        int pivot = partisjoner(a, start, slutt); // kall partisjoner for å finne pivot

        // recursion
        quickSort(a, start, pivot); // første halvdel (fram til (inkl) pivot)
        quickSort(a, pivot + 1, slutt); // andre halvdel (fra verdi etter pivot)
    }

    public static int partisjoner(int[] a, int start, int slutt) {
        int pivot = a[slutt]; // siste verdi i arrayet
        int v = start;
        int h = slutt - 1; // -1 fordi  det aller siste er valgt som pivot - NB burde det ikke være -2?

        while (v <= h) {
            // så lenge v er mindre enn siste indeks og mindre (verdi) enn pivot, gå videre til neste indeks
            while (v <= slutt && a[v] < pivot) { v++;}
            // så lenge h er større enn første indeks og større (verdi) enn pivot, gå videre til neste indeks (innover)
            while (h >= start && a[h] > pivot) { h--;}

            // dersom while-betingelsen blir usann hopper den ut, når den hoppe ut på begge sider har vi 2 kandidater
            // sjekk først at v og h ikke er på samme indeks eller har byttet plass
            if (v < h) {
                // her kunne du kalt en hjelpefunksjon
                // bytt (a, v, h);
                int temp = a[v];
                a[v] = a[h];
                a[h] = temp;
            }
        }
        // når v og h har krysset, bytter vi pivot med element h slik at det kommer på korrekt plass i arrayet
        // igjen - kulle kalt bytt()
        int temp = a[v];
        a[v] = a[h];
        a[h] = temp;

        // h holder nå pivots nye plassering
        System.out.println("posisjon til nåværende pivot: " + h);
        return h;

        // det vil nå kjøre igjen, inntil tabellen ikke kan deles i mindre biter -> recursion
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8,9};
        int[] segregert = parterParOdd(a); // fungerer - den deler i partall og oddetall

        System.out.println(Arrays.toString(segregert));

        quickSort(segregert, 0, a.length - 1); // fungerer ikke - tallene er ikke sortert, og forstår ikke logikken
        for(int i : segregert) {
            System.out.print("verdi: " + i + ", ");
           // System.out.print("posisjon:" + segregert[i] + ", ");
        }
    }
}
