package oopconcepts;

public class OOPConcepts {
    public static void main(String[] args) {
        Animal[] animalList = new Animal[6];  // fill the animalList
        for (Animal animal : animalList) {
            System.out.println(animal);       // print out all info of that animal
            animal.makeNoise();               // polymorphism in action
            animal.eat();
            animal.sleep();
            animal.roam();
        }

        Pet[] petList = new Pet[3];   // fill the petList
        for (Pet pet : petList) {
            System.out.println(pet);  // print out all info of that pet
            pet.doSomething();        // polymorphism in action
        }
    }
}
