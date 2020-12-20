package oopconcepts;

public class Destroyer extends Robot {

    @Override
    public void getEnergyStatus() {
        System.out.println("The destroyer is out of energy");
    }

    @Override
    public void madeIn() {
        System.out.println("The destroyer is made in China");
    }
}
