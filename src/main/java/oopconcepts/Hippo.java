package oopconcepts;

public class Hippo extends Animal {

    Hippo(int weight, int age) {
        super(weight, age);
    }

    @Override
    public void makeNoise() {
        System.out.println("The hippo makes sound");
    }

    @Override
    public void eat() {
        System.out.println("The hippo eats something");
    }

    @Override
    public void roam() {
        System.out.println("The hippo is roaming.");
    }
}
