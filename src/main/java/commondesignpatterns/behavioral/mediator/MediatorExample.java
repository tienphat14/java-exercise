package commondesignpatterns.behavioral.mediator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MediatorExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(MediatorExample.class);

    public static void main(String[] args) {
        PowerButton powerButton = new PowerButton();
        SwingButton swingButton = new SwingButton();
        Mediator mediator = new MediatorImpl(powerButton, swingButton);
        LOGGER.info("Start testing");
        LOGGER.info("Power is on: {}", powerButton.isOn());
        LOGGER.info("Swing is on: {}", swingButton.isOn());
        swingButton.press();
        LOGGER.info("When power is off, press swing nothing happen");
        LOGGER.info("Power is on: {}", powerButton.isOn());
        LOGGER.info("Swing is on: {}", swingButton.isOn());
        powerButton.press();
        LOGGER.info("Turn power on");
        LOGGER.info("Power is on: {}", powerButton.isOn());
        LOGGER.info("Swing is on: {}", swingButton.isOn());
        swingButton.press();
        LOGGER.info("When power is on, press swing work");
        LOGGER.info("Power is on: {}", powerButton.isOn());
        LOGGER.info("Swing is on: {}", swingButton.isOn());
        powerButton.press();
        LOGGER.info("Turn power off");
        LOGGER.info("Power is on: {}", powerButton.isOn());
        LOGGER.info("Swing is on: {}", swingButton.isOn());
    }
}
