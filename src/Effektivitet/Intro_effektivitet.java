package Effektivitet;

// tell antall operasjoner, identifiser de mest sentrale/kostbare
// tell antall ganger de gjennomføres (i ulike scenario)

public class Intro_effektivitet {

    //finn største verdi i et array
    public static int finnStørste(int[] values) {
        int maksverdi = values[0];
        // 2 operasjon 1 gang - tilegning av verdi fra array, aksessering av array (indeksering) - 2*1

        for (int i = 1; i < values.length; i++) { // 1 + n + (n-1) ?? (1 + n-1 + n-1)
            // operasjoner: tilegning av verdi i = 1 - 1 gang
            // sammenligning i < a.length, indeksering (aksessering av array) - n-1 gang ettersom vi starter på indeks 0
            // øking av i - skjer n-2 ganger fordi det ikke skal økes siste gang (ville overskride lengen ?)

            int verdi = values[i]; // tildeling av verdi, aksessering av array (indeksering) - 2 operasjon, hver gang loopen kjører - 2 * (n-1)
            if (verdi > maksverdi) { // sammenligning av verdi - 1 operasjon pr loop - 1* (n-1)
                maksverdi = verdi; // tilegning av verdi, hver gang verdi > maksverdi - x
                                    // avhengig av hvilke data vi får inn  -> vi må finne gj.snitt / sannsynlighet ?
            }
        }
        return maksverdi;
    }

    public static void main (String[] args) {
        // int[] values = {16, 7, 8, 9, 2, 7, 6};
        int[] values = {16, 3, 8, 19, 22, 7, 26}; // 37 operasjoner når arrayet er 7 langt = 5n-1 + x -> kompleksitet O(n) dobler input dobler output
        // hvordan blir n + (n-1) til n ?

        // kaller metoden i sout for å printe resulatet
        System.out.println("Største verdi i arrayet: " + finnStørste(values));
    }
}
