package oopconcepts;

public class Dog extends Canine implements Pet {

    Dog(int weight, int age) {
        super(weight, age);
    }

    @Override
    public void makeNoise() {
        System.out.println("The dog makes sound");
    }

    @Override
    public void eat() {
        System.out.println("The dog eats something");
    }

    @Override
    public void beFriendly() {
        System.out.println("The dog is friendly");
    }

    @Override
    public void play() {
        System.out.println("The dog likes playing with the owner");
    }

    @Override
    public void getPetInfo() {
        System.out.println("The dog is pet and its info - weight: " + getWeight() + " - age: " + getAge());
    }
}
