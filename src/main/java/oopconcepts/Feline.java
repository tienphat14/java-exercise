package oopconcepts;

public abstract class Feline extends Animal {
    Feline(int weight, int age) {
        super(weight, age);
    }

    @Override
    public void roam() {
        System.out.println("The feline is roaming.");
    }
}
