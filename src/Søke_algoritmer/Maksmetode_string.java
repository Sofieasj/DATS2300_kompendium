package Søke_algoritmer;

public class Maksmetode_string {

    // for å sammenligne strings kan vi ikke bruke a < maks, men .compareTo(maks)

    public static int maks(String[] a)    // legges i class Tabell
    {
        int m = 0;                          // indeks til største verdi
        String maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer * posisjonen * til største verdi
    }

    public static void main(String[] args) {
        String[] s = {"ad", "bd", "cd", "da"};
                // {"Sohil", "Per", "Thanh", "Faima", "Kari", "Jasmin"};
        int k = maks(s);

        System.out.println("posisjon: " + k + " verdi: " + s[k]);
        // returnerer den stringen som starter med bokstav lengst ut i alfabetet (høyest alfabetisk indeks)

    }
}
