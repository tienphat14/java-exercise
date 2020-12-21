package oopconcepts;

public class Destroyer extends Robot {

    @Override
    public void voice() {
        System.out.println("Voice is from the speaker");
    }

    @Override
    public boolean isControlRobot(boolean isControl) {
        return isControl;
    }
}
