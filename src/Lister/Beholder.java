package Lister;

// interface - klasser som implementerer må ha metodene herfra
public interface Beholder<T> {

    // tar inn et element som skal legges inn, returnerer true/false om det returneres eller ei
    boolean leggInn(T t);

    // tar inn et element som skal fjernes, returnerer true/false om det fjernes eller ei
    boolean fjern(T t);

    // returnerer antall elementer i listen (int)
    int antall();

    // sjekker om listen er tom - returnerer true/false
    boolean tom();

    // sjekker om listen inneholder den innsendte verdien - returnerer true/false
    boolean inneholder(T t);

    // tilbakestiller listen, returnerer ingenting
    void nullstill();
}