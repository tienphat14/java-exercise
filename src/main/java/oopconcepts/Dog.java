package oopconcepts;

public class Dog extends Canine implements Pet {
    @Override
    public void keepTheHouse() {
        System.out.println("Dog keeps the House");
    }
}
