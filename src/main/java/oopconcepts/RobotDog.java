package oopconcepts;

public class RobotDog extends Robot implements Pet {


    @Override
    public String petColor(String color) {
        return color;
    }

    @Override
    public int petWeight(int weight) {
        return weight;
    }

    @Override
    public void voice() {
        System.out.println("Voice from speaker. Gau gau gau gau");
    }

    @Override
    public boolean isControlRobot(boolean isControl) {
        return isControl;
    }
}
