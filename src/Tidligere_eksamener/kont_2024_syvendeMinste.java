package Tidligere_eksamener;

public class kont_2024_syvendeMinste {
    public static void main(String[] args) {
        int[] a = {8, 4, 9, 5, 2, 3, 1, 7, 0, 6};
    }

    public int syvendeMinste(int[] a) {
        // skjønner ikke helt dette - må jeg ikke først sortere a?
        sorter(a);

        // legg de 7 første elementene i tabellen inn i en hjelpetabell
        int[] b = new int [7];
        for(int i = 0; i < 7; i++) {
            b[i] = a[i];
        }

        // sorter hjelpetabellen
        sorter(b);

        // sjekk om et element i a er større enn verdiene i hjelpetabellen
        for(int i = 7; i < a.length; i++) {
            for(int j = 0; j < 7; j++) {
                if(a[i] == b[j]) {
                    b[6] = a[i];
                    sorter(b);
                }
            }
        }
        return b[6];
    }

    public int[] sorter (int[] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length; j++) {
                if(a[i] > a[j]) { // korriger inversjon - sorter fra minst til størst
                    int tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
        }
        return a;
    }
}
