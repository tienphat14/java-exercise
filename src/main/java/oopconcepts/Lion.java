package oopconcepts;

public class Lion extends Feline {
    public Lion(int weight, int age) {
        super(weight, age);
    }

    @Override
    public void makeNoise() {
        System.out.println("Roar.");
    }

    @Override
    public void eat() {
        System.out.println("Meat.");
    }

    @Override
    public void roam() {
        System.out.println("Dry grass.");
    }
}
