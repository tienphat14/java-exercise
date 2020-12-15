package oopconcepts;

public class Cat extends Feline implements Pet {
    @Override
    public void keepTheHouse() {
        System.out.println("Cat gets mouse away");
    }


}
