package oopconcepts;

public class RobotDog extends Robot implements Pet {
    @Override
    public void ownedBy() {
        System.out.println("Phat Phan");
    }

    @Override
    public void madeBy() {
        System.out.println("Plastic.");
    }

    @Override
    public void createdFor() {
        System.out.println("Look after the house.");
    }

    @Override
    public String getPetInfo() {
        return this.getClass().getSimpleName();
    }
}
