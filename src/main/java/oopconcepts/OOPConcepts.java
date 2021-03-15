package oopconcepts;

public class OOPConcepts {
    public static void main(String[] args) {

        Animal[] animalList = new Animal[]{new Dog(60, 1), new Cat(40, 2), new Tiger(70, 4),
                new Lion(60, 3), new Wolf(35, 2), new Hippo(40, 4)};  // fill the animalList
        for (Animal animal : animalList) {
            System.out.println(animal.getInfo());       // print out all info of that animal
            animal.makeNoise();               // polymorphism in action
            animal.eat();
            animal.sleep();
            animal.roam();
        }

        Pet[] petList = new Pet[]{new Dog(60, 1), new Cat(40, 2), new RobotDog()};   // fill the petList
        for (Pet pet : petList) {
            System.out.println(pet.getPetInfo());  // print out all info of that pet
            pet.ownedBy();        // polymorphism in action
        }

    }
}
