package oopconcepts;

public class Tiger extends Feline {
    public Tiger(int weight, int age) {
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
        System.out.println("Forest.");
    }
}
