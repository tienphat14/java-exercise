package oopconcepts;

abstract class Animal {
    private double weight;
    private int age;
    private String sex;

    public void makeNoises(){
        System.out.println("Make some noises");
    }
    public void eat(){
        System.out.println("Eat fresh meat");
    }
    public void sleep(){
        System.out.println("Can sleep");
    }
    public void roam(){
        System.out.println("Like to roam somewhere");
    }
}
