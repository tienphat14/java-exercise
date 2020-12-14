package oopconcepts;

public class Wolf extends Canine {
    public Wolf(int weight, int age) {
        super(weight, age);
    }

    @Override
    public void makeNoise() {
        System.out.println("Howl.");
    }

    @Override
    public void eat() {
        System.out.println("Meat.");
    }

    @Override
    public void roam() {
        System.out.println("Forest.");
    }
}
