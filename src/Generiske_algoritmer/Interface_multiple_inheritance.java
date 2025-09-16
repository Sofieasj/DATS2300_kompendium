package Generiske_algoritmer;

// interface - addisjon
interface Add {
    // metode for addisjon
    int add(int a, int b);
}

// interface - substraksjon
interface Sub {
    int sub(int a, int b);
}

// class calculator implementerer substraksjon og addisjon
class Calc implements Add, Sub {

    // metode fra Add - fylt ut
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    // metode fra Sub - fylt ut
    @Override
    public int sub(int a, int b) {
        return a - b;
    }
}

public class Interface_multiple_inheritance {
    public static void main(String[] args) {
        // instansier calc
        Calc calc = new Calc();

        System.out.println("Addisjon: " + calc.add(10, 20));
        System.out.println("Subtraksjon: " + calc.sub(30, 20));
    }
}
