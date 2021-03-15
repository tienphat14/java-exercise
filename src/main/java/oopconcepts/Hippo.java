package oopconcepts;

public class Hippo extends Animal {
    public Hippo(int weight, int age) {
        super(weight, age);
    }

    @Override
    public void makeNoise() {
        System.out.println("Hippo Hippo.");
    }

    @Override
    public void eat() {
        System.out.println("Hippo eats grass.");
    }

    @Override
    public void roam() {
        System.out.println("Hippo lives in freshwater habitats.");
    }
}
