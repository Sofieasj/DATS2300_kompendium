package Generiske_algoritmer;

// superklasse med definerte variabler og metoder!
class Vehicle2 {
    // protected - attributt/metode/konstruktør blir tilgjengelig innenfor package og subklasser
    // pga konstruktør skal variabelen IKKE være definert her
    protected String brand = "Ford";

    // konstruktør - super
    public Vehicle2(String brand) {
        this.brand = brand;
    }

    public void honk() {
        System.out.println("honk, honk");
    }
}

class Car extends Vehicle2 {
    // lokale variabler - burde være private, da må vi ha get() for å hente den ut
    String modelName;

    // konstruktør - har både sin egen OG arvet fra super
    public Car(String brand, String modelName) {
        super(brand); // forteller at dette skjer i superklassen
        this.modelName = modelName;
    }

    //inneholder nå honk(), fordi den arver fra superklassen
}

public class Inheritance_subsuper {
    public static void main(String[] args) {
        // instansier Car-obj - pga konstruktør sender vi med parameter
        // bran fra super og modelName fra sub
        Car car = new Car("Ford", "Mustang");
        // kall honk() - den ligger i superklassen, arves derfra
        car.honk();

        // output - bilmodell (super) og navn (sub)
        System.out.println(car.brand + " " + car.modelName);
    }
}
