package oopconcepts;

public class Lion extends Feline {
    @Override
    public boolean isWild(boolean isWild) {
        return isWild;
    }
    @Override
    public int weight(int weight) {
        return weight;
    }

    @Override
    public int age(int age) {
        return age;
    }

    public void animalKing(){
        System.out.println("Lion is animal king");
    }
}
