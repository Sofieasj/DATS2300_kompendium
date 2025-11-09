package Søke_algoritmer;

public class Lineærsøk {
    public static void main(String[] args) {
        int [] a = {3, 7, 4, 1, 2, 8, 9, 1};
        int størst = StørsteVerdi(a);
        System.out.println(størst);
        int minst = MinsteVerdi(a);
        System.out.println(minst);
        int nestStørst = Størst_NestStørst(a);
        System.out.println(nestStørst);
    }

    static int StørsteVerdi (int [] a) {
        int maks = a[0];

        // iterer gjennom hele arrayet
        for (int i = 1; i < a.length; i++) {
            // dersom denne verdien er større enn maksverdien (til nå) -> oppdater maksverdi
            if (a[i] > maks) {
                maks = a[i];
            }
        }
        return maks;
    }

    static int MinsteVerdi (int [] a) {
        int min = a[0];

        // iterer gjennom hele arrayet
        for (int i = 1; i < a.length; i++) {
            // dersom i er mindre enn minste verdi til nå -> oppdater minste
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    static int Størst_NestStørst (int [] a) {
        int maks = a[0];
        int nest = a[0];

        for (int i = 1; i < a.length; i++) {
            // dersom i er større enn nest størst
            if (a[i] > nest) {
                // sjekk om den også er større enn største
                if (a[i] > maks) {
                    // da må vi oppdatere både neststørst og størst
                    nest =  maks;
                    maks = a[i];
                } else {
                    nest = a[i];
                }
            }
        }
        return nest;
    }
}
