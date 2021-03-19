package commondesignpatterns.behavioral.mediator;

public class PowerButton {

    private Mediator mediator;
    private boolean isOn = false;

    public void press() {
        mediator.notify(this, "Press Power");
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
