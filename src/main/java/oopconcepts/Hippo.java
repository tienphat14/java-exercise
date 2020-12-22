package oopconcepts;

public class Hippo extends Animal {
    @Override
    public int weight(int weight) {
        return weight;
    }

    @Override
    public int age(int age) {
        return age;
    }

    public void living(){
        System.out.println("Hippo is living in the river");
    }
}
