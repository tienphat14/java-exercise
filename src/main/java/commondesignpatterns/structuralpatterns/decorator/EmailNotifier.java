package commondesignpatterns.structuralpatterns.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailNotifier implements Notifier {

    private static Logger LOGGER = LoggerFactory.getLogger(EmailNotifier.class);

    @Override
    public void send(String message) {
        LOGGER.info("Sending to email: {}", message);
    }
}
