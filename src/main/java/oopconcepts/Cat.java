package oopconcepts;

public class Cat extends Feline implements Pet {

    Cat(int weight, int age) {
        super(weight, age);
    }

    @Override
    public void makeNoise() {
        System.out.println("The cat makes sound");
    }

    @Override
    public void eat() {
        System.out.println("The cat eats something");
    }

    @Override
    public void beFriendly() {
        System.out.println("The cat is friendly");
    }

    @Override
    public void play() {
        System.out.println("The cat likes playing with the owner");
    }

    @Override
    public void getPetInfo() {
        System.out.println("The cat is pet and its info - weight: " + getWeight() + " - age: " + getAge());
    }
}
