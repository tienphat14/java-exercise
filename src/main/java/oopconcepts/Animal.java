package oopconcepts;

public abstract class Animal {
    private int weight;
    private int age;

    public Animal (int weight, int age) {
        this.weight = weight;
        this.age = age;
    }
    public abstract void makeNoise();
    public abstract void eat();
    public abstract void roam();

    public void sleep() {
        System.out.println("Animal is sleeping.");
    }

    public String getInfo() {
        return this.getClass().getSimpleName() + " Weight: " + weight + " kg. Age: " + age + " years old.";
    }
}
