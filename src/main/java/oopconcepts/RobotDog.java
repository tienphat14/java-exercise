package oopconcepts;

public class RobotDog extends Robot implements Pet {

    @Override
    public void getEnergyStatus() {
        System.out.println("The robot dog has full energy");
    }

    @Override
    public void madeIn() {
        System.out.println("The robot dog is made in USA");
    }

    @Override
    public void beFriendly() {
        System.out.println("The robot dog is friendly");
    }

    @Override
    public void play() {
        System.out.println("The robot dog likes playing with the owner");
    }

    @Override
    public void getPetInfo() {
        System.out.println("The robot dog is a pet. It is made in USA");
    }
}
