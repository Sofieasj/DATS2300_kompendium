package Søke_algoritmer;

public class Maksmetode_double {

    public static int maks(double[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

    public static void main(String[] args) {
        double[] d = {5.7, 3.14, 7.12, 3.9, 6.5, 7.1, 7.11};
        int k = maks(d); // metoden returnerer posisjonen
        System.out.println("posisjon: " + k + " verdi: " + d[k]);
        // verdi - arrayet[indeks fra metoden, lagret i k]
    }
}
