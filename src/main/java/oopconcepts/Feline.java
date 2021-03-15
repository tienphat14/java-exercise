package oopconcepts;

public abstract class Feline extends Animal{
    public Feline(int weight, int age) {
        super(weight, age);
    }

    public void liveWith() {
        System.out.println("Felines are solitary.");
    }
}
