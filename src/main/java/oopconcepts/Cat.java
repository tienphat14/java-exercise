package oopconcepts;

public class Cat extends Feline implements Pet {
    @Override
    public String petColor(String color) {
        return color;
    }

    @Override
    public int petWeight(int weight) {
        return weight;
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
