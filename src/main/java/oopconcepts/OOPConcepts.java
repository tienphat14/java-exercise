package oopconcepts;

public class OOPConcepts {
    public static void main(String[] args) {

        Animal[] animalList = new Animal[6];
        animalList[0] = new Cat(10, 1);
        animalList[1] = new Tiger(200, 3);
        animalList[2] = new Lion(300, 3);
        animalList[3] = new Wolf(50, 2);
        animalList[4] = new Dog(30, 2);
        animalList[5] = new Hippo(1000, 5);

        for (Animal animal : animalList) {
            animal.getAnimalInfo();
            animal.makeNoise();
            animal.eat();
            animal.sleep();
            animal.roam();
        }

        Pet[] petList = new Pet[3];
        petList[0] = new RobotDog();
        petList[1] = new Dog(35, 2);
        petList[2] = new Cat(15, 1);

        for (Pet pet : petList) {
            pet.getPetInfo();
            pet.beFriendly();
            pet.play();
        }


    }
}
