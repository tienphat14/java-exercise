package oopconcepts;

public class Dog extends Canine implements Pet {
    public Dog(int weight, int age) {
        super(weight, age);
    }

    @Override
    public void makeNoise() {
        System.out.println("Bark.");
    }

    @Override
    public void eat() {
        System.out.println("Dog foods.");
    }

    @Override
    public void roam() {
        System.out.println("House or street.");
    }

    @Override
    public void ownedBy() {
        System.out.println("Tuan Nguyen");
    }

    @Override
    public String getPetInfo() {
        return this.getClass().getSimpleName();
    }
}
