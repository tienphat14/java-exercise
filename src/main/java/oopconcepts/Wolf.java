package oopconcepts;

public class Wolf extends Canine {

    Wolf(int weight, int age) {
        super(weight, age);
    }

    @Override
    public void makeNoise() {
        System.out.println("The wolf makes sound");
    }

    @Override
    public void eat() {
        System.out.println("The wolf eats something");
    }
}
