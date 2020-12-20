package oopconcepts;

public class Tiger extends Feline {

    Tiger(int weight, int age) {
        super(weight, age);
    }

    @Override
    public void makeNoise() {
        System.out.println("The tiger makes sound");
    }

    @Override
    public void eat() {
        System.out.println("The tiger eats something");
    }
}
