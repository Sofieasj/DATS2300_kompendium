//package Sorterings_algoritmer;
//
//public class oblig_1_4 {
//    // hjelpemetode
//    public static void bytt(int[] a, int i, int j) {
//        int temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }
//
//    // Oppgave 4
//    public static void delsortering(int[] a) {
//
//        // SEGREGER PARTALL OG ODDETALL
//        int v = 0;
//        int h = a.length - 1;
//
//        // alternativ sjekk for tom tabell - startindeks er >= sluttindeks
//        // mer effektivt enn a.length < 1 ? trenger ikke kjøre length på arrayet, kun sammenligne
//        if(v >= h) {
//            return;
//        }
//
//        while (v <= h) {
//            while (v <= h && a[v] % 2 != 0) { v++; }
//            while (v <= h && a[h] % 2 == 0) { h--; }
//
//            // splitt i partall og oddetall
//            if (v < h) {
//                bytt(a, v, h);
//                v++;
//                h--;
//            }
//        }
//
//        // SORTER DE TO DELENE AV ARRAYET
//
//
//    }
//
//    public static void sorterArray(int[] a, int start, int slutt){
//        // base case - hvis sluttindex <= startindex er det 0-1 element igjen
//        if(slutt <= start) {
//            return;
//        }
//
//        // kall partisjoneringsmetode for å finne pivot
//
//        // recursion
//        sorterArray(a, start, pivot); // første halvdel (fram til pivot)
//        sorterArray(a, pivot + 1, slutt); // andre halvdel (inkl pivot?)
//    }
//}
