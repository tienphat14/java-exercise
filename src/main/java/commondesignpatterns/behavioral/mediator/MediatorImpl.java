package commondesignpatterns.behavioral.mediator;

public class MediatorImpl implements Mediator {

    private PowerButton powerButton;
    private SwingButton swingButton;

    public MediatorImpl() {
        powerButton = new PowerButton();
        swingButton = new SwingButton();
        powerButton.setMediator(this);
        swingButton.setMediator(this);
    }

    public MediatorImpl(PowerButton powerButton, SwingButton swingButton) {
        this.powerButton = powerButton;
        this.swingButton = swingButton;
        powerButton.setMediator(this);
        swingButton.setMediator(this);
    }

    @Override
    public void notify(Object sender, String event) {
        if (sender instanceof PowerButton) {
            PowerButton button = (PowerButton) sender;
            button.setOn(!button.isOn());
            if (!powerButton.isOn()) {
                swingButton.setOn(false);
            }
        } else if (sender instanceof SwingButton) {
            SwingButton button = (SwingButton) sender;
            if (powerButton.isOn()) {
                button.setOn(!button.isOn());
            }
        }
    }
}
