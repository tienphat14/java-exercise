package commondesignpatterns.structuralpatterns.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlackNotifier extends NotifierDecorator {

    private static Logger LOGGER = LoggerFactory.getLogger(EmailNotifier.class);

    public SlackNotifier(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        LOGGER.info("Sending to slack: {}", message);
        super.send(message);
    }
}
