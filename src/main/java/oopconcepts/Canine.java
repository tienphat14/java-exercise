package oopconcepts;

public abstract class Canine extends Animal{
    public Canine(int weight, int age) {
        super(weight, age);
    }
    public void liveWithGroup() {
        System.out.println("Canines are group living animals.");
    }
}
