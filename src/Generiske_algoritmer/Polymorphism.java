package Generiske_algoritmer;

// superklassen - med en *definert* metode! NB den behøver ikke være abstrakt
class Animal {
    public void animalSound() {
        System.out.println("The animal makes a sound");
    }
}

// subklassen arver fra super - tilpasser arvet metode!
class Pig extends Animal {
    public void animalSound() {
        System.out.println("The pig says wee wee");
    }
}

class Dog extends Animal {
    public void animalSound() {
        // tilpasser arvet metode
        System.out.println("The dog says woof woof");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        // grunnklassen (super)
        Animal animal = new Animal();
        animal.animalSound();

        // arv - sub klasse
        Pig pig = new Pig();
        pig.animalSound();

        // arv - sub klasse
        Dog dog = new Dog();
        dog.animalSound();
    }
}
