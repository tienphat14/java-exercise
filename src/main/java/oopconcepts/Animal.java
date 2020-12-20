package oopconcepts;

public abstract class Animal {
    private int weight;
    private int age;

    Animal(int weight, int age) {
        this.weight = weight;
        this.age = age;
    }

    public abstract void makeNoise();
    public abstract void eat();
    public abstract void roam();
    public void sleep() {
        System.out.println("The animal is sleeping.");
    };
    public void getAnimalInfo() {
        System.out.println("Weight: " + getWeight() + ". Age: " + getAge());
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
