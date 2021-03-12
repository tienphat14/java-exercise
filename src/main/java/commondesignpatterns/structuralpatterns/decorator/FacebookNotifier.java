package commondesignpatterns.structuralpatterns.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FacebookNotifier extends NotifierDecorator {

    private static Logger LOGGER = LoggerFactory.getLogger(EmailNotifier.class);

    public FacebookNotifier(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        LOGGER.info("Sending to facebook: {}", message);
        super.send(message);
    }
}
