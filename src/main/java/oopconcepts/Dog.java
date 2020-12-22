package oopconcepts;

public class Dog extends Canine {
    @Override
    public void canineType() {
        System.out.println("This is a Dog");
    }

    @Override
    public int weight(int weight) {
        return weight;
    }

    @Override
    public int age(int age) {
        return age;
    }
}
