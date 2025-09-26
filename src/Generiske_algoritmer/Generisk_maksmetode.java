package Generiske_algoritmer;

public class Generisk_maksmetode {

//    public static <T> int maks(T[] a) {
//        // T står for type (datatype)
//        // <T> forteller at T er en ! typeparameter ! -> en hvilken som helst referansetype (ikke primitiv)
//        return;
//    }
}

    // bruk interface (grensesnitt for å lage sammenligningsmetode)
    interface Comparable<T>   // definert i java.lang
    {
        public int compareTo(T o);
    }

