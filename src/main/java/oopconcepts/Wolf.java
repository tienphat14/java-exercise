package oopconcepts;

public class Wolf extends Canine {
    @Override
    public void canineType() {
        System.out.println("This is a Wolf");
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
