package oopconcepts;

public abstract class Canine extends Animal {
    Canine(int weight, int age) {
        super(weight, age);
    }

    @Override
    public void roam() {
        System.out.println("The canine is roaming.");
    }
}
