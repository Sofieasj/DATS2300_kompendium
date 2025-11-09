package Sorterings_algoritmer;

// avg O(n^2) - pga to nestede forløkker
// best case (pga. break) er O(n) - vi går gjennom alt 1 gang og ser at verdiene er sortert

// vi sorterer arrayet fra laveste til høyeste verdi ved å "boble"
// høyere verdier oppover i arrayet, hver gang vi finner en inversjon

// vi bruke loop og går gjennom arrayet, en verdi om gangen
// for hver verdi ssammenligner vi med neste verdi (inversjon)
// dersom det er en inversjon, bytter vi verdiene
// vi iterer n ganger gjennom arrayet

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {4, 7, 5, 2, 1, 8, 6 ,4, 9, 3};
        boble(a);
        for(int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void boble(int[] a) {
        // sjekk at det er minst 1 verdi - noe å sortere
        if (a.length <= 1) {
            throw new IllegalArgumentException("Det er 1 eller 0 elementer, ingenting å sortere");
        }

        // iterer gjennom arrayet
        for (int i = 0; i < a.length - 1; i++) {
            boolean swapped = false; // ingen bytter så langt

            // sammenlign med alle de andre verdiene
            for (int j = i + 1; j < a.length; j++) {
                // sjekk for inversjon
                if ( a[i] > a[i + 1]) {
                    // bytt!
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true; // vi har gjort et bytte
                }
            }
            // dersom vi har gått gjennom 1 gang uten å bytte noen verdier er arrayet alt sortert!
            if (!swapped) {
                break;
            }

        }
    }

}
