package Lister;

// extender Beholder - dvs klasser som implementerer må ha metodene herfra OG fra beholder ettersom den blir extended
public interface Liste<T> extends Beholder<T> {
    // metoder som i praksis legges til dem definert i Beholder (?)

    // legg inn innsendt element på innsident indeks - returnerer true/false for om det gikk
    boolean leggInn(int indeks, T t);

    // hent/returner et element på gitt indeks
    T hent(int indeks);  // returnerer et element av typen T

    // oppdaterer et element på innsendt indeks, med innsendt verdi, og returnerer element av typen T
    T oppdater(int indeks, T t);

    // tar inn en indeks hvor elementet skal fjernes, returnerer true/false for om det gikk
    boolean fjern(int indeks);

    // returnerer indeksen til et insendt element
    int indeksTil(T t);
}
