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

    public void dangerosRobot(){
        System.out.println("This is a dangerous robot. It can destroy anything");
    }
}
