package Søke_algoritmer;

//finn største verdi i et array
public class Største_verdi {

    public static int finnStørste(int[] values) {
        int maksverdi = values[0]; //setter verdi i indeks 0 som startverdi

        // loop over resterende verdier
        // starter på 1 fordi vi alt har satt indeks 0 som "maksverdi"
        for (int i = 1; i < values.length; i++) {
            // mindre enn total length - unngår å gå utenfor arrayet - IndexutOfBounds (går utenfor maskinens minne)
            // ved å bruke length slipper vi risiko for å skrive feil indeks-lengde og få erroren over

            int verdi = values[i]; // verdien på indeks i
            if (verdi > maksverdi) {
                maksverdi = verdi; // dersom verdien til "verdi" er større enn den i "maksverdi",
                                    // byttes maksverdi ut for den nye verdien
            }
        }
        return maksverdi;
    }

    public static void main (String[] args) {
        // int[] values = {16, 7, 8, 9, 2, 7, 6};
        int[] values = {16, 3, 8, 19, 22, 7, 26};

        // kaller metoden i sout for å printe resulatet
        System.out.println("Største verdi i arrayet: " + finnStørste(values));
    }
}
