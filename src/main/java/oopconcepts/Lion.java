package oopconcepts;

public class Lion extends Feline {

    Lion(int weight, int age) {
        super(weight, age);
    }

    @Override
    public void makeNoise() {
        System.out.println("The lion makes sound");
    }

    @Override
    public void eat() {
        System.out.println("The lion eats something");
    }
}
