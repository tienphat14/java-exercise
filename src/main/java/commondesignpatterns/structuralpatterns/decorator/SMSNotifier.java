package commondesignpatterns.structuralpatterns.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMSNotifier extends NotifierDecorator {

    private static Logger LOGGER = LoggerFactory.getLogger(EmailNotifier.class);

    public SMSNotifier(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        LOGGER.info("Sending to SMS: {}", message);
        super.send(message);
    }
}
