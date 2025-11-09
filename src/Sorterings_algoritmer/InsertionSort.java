package Sorterings_algoritmer;

// vi starter med å anta at første verdi i arrayet er sortert
// vi ser på neste verdi og ser om det er en inversjon mellom denne og den foregående
// dersom det er det bytter vi plass
// derett går vi til neste indeks - vi ser på det er en inversjon ml. denne og den foregående
// dersom det er det, bytter vi, og så sjekker vi for inversjon ml denne og den (eller de) foregående elementene
// vi repeterer dette inntil vi har vært gjennom hvert element og vet at det er rett plassert
// fordi vi antar at første verdi er sortert trenger vi ikke sortere denne - altså kjører vi gjennom arrayet n-1 ganger
// fordi vi har nestede løkker er avg. kompleksitet O(n^2), mens best case (alt er sortert) er O(n)

public class InsertionSort {
    public static void main(String[] args) {
        int [] a = {2, 4, 6, 7, 3, 1, 3, 5, 9};
        sorter(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    static void sorter (int [] a) {
        // start på indeks 1 fordi vi antar at a[0] er sortert
        // ytre loop er elementet vi nå skal sortere
        for (int i = 1; i < a.length; i++) {
            int key = a[i]; // verdien vi nå skal sortere
            int j = i-1; // start på siste sorterte element (til venstre for key)

            // indre loop er sammenligningen - vi ser om sorterte elementer er større enn key
            // isåfall - flytt disse elementene til høyre og lag plass til key
            while (j >= 0 && a[j] > key) { // >= 0 holder oss innenfor arrayet
                // flytt elementet ett steg til høyre
                a[j+1] = a[j]; //
                j--; // flytt j-pekeren "bakover", mot venstre
            }

            // vi har flyttet alle de sorterte verdiene som er større enn key, og kan nå legge den inn på rett plass
            a[j+1] = key;
        }
    }
}
