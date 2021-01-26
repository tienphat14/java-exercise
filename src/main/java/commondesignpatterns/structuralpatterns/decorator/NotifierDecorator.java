package commondesignpatterns.structuralpatterns.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotifierDecorator implements Notifier {

    private static Logger LOGGER = LoggerFactory.getLogger(EmailNotifier.class);

    private Notifier wrappee;

    public NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void send(String message) {
        wrappee.send(message);
    }
}
