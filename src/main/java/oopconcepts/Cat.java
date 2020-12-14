package oopconcepts;

public class Cat extends Feline implements Pet {
    public Cat(int weight, int age) {
        super(weight, age);
    }

    @Override
    public void makeNoise() {
        System.out.println("Meow.");
    }

    @Override
    public void eat() {
        System.out.println("Cat food or fish.");
    }

    @Override
    public void roam() {
        System.out.println("House or street.");
    }

    @Override
    public void ownedBy() {
        System.out.println("Ha Tran");
    }

    @Override
    public String getPetInfo() {
        return this.getClass().getSimpleName();
    }
}
