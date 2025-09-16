package Generiske_algoritmer;

interface Vehicle {

    // deklarer abstrakte emtoder
    void changeGear(int a);
    void speedUp(int a);
    void applyBreaks(int a);
}

// Sykkel - class implementerer vehicle interfacet
class Bicycle implements Vehicle {

    //lokale variabler
    int speed;
    int gear;

    // arvede metoder har alltid @Override
    @Override
    public void changeGear(int newGear) {
        gear = newGear;
    }

    @Override
    public void speedUp(int increment) {
        speed += increment; // legger til økning
    }

    @Override
    public void applyBreaks(int decrement) {
        speed -= decrement; // trekker fra reduksjon
    }

    // lokal - ikke arvet
    public void printStates() {
        System.out.println("Speed: " + speed + " Gear:" + gear);
    }
}

// motorsykkel - class implementerer interface
class Bike implements Vehicle {
    //lokale variabler
    int speed;
    int gear;

    // arvede metoder har alltid @Override
    @Override
    public void changeGear(int newGear) {
        gear = newGear;
    }

    @Override
    public void speedUp(int increment) {
        speed += increment; // legger til økning
    }

    @Override
    public void applyBreaks(int decrement) {
        speed -= decrement; // trekker fra reduksjon
    }

    public void printStates() {
        System.out.println("speed: " + speed
                + " gear: " + gear);
    }
}

public class Interface_recap {
    public static void main(String[] args) {
        // instansier objekter sykkel
        Bicycle bicycle = new Bicycle();
        // kall metoder for å oppdatere verdier
        bicycle.changeGear(5);
        bicycle.speedUp(5);
        bicycle.applyBreaks(5);
        // print ut-metode
        bicycle.printStates();

        // instansier obj - motorsykkel
        Bike bike = new Bike();
        bike.changeGear(10);
        bike.speedUp(10);
        bike.applyBreaks(10);
        // kall sout-metode
        bike.printStates();
    }
}
