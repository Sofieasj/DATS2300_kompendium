package Søke_algoritmer;

public class Lineærsøk_string {

    // for å sammenligne strings kan vi ikke bruke a < maks, men .compareTo(maks)

    public static int maks(String[] a) {
        int m = 0;          // indeks til største verdi
        String maksverdi = a[0];     // største verdi

        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[i];  // største verdi oppdateres
                m = i;    // indeks til største verdi oppdaters
            }
        }
        return m;  // returnerer * posisjonen * til største verdi
    }

    public static int min(String[] a) {
        int m = 0; // indeks til minste verdi
        String minverdi = a[0]; // startverdi, minste element

        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(minverdi) < 0) {
                minverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        String[] s = {"ad", "bd", "cd", "da"};
        String[] t = {"Sohil", "Per", "Thanh", "Faima", "Kari", "Jasmin"};
        int k = maks(s);
        int l = maks(t);
        int m = min(s);
        int n = min(t);

        // returnerer den stringen som starter med bokstav lengst ut i alfabetet (høyest alfabetisk indeks)
        System.out.println("posisjon: " + k + " verdi: " + s[k]);
        System.out.println("posisjon: " + l + " verdi: " + t[l]);

        // returnerer string med forbokstav først i alfabetet - som ordbok (lavest alfabetisk indeks)
        System.out.println("posisjon: " + m + " verdi: " + s[m]);
        System.out.println("posisjon: " + n + " verdi: " + t[n]);


    }
}
