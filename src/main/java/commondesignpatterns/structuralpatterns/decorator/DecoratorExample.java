package commondesignpatterns.structuralpatterns.decorator;

public class DecoratorExample {

    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        notifier.send("This message is sent to email only");

        notifier = new FacebookNotifier(notifier);
        notifier.send("This message is sent to facebook first then to email");

        notifier = new SlackNotifier(notifier);
        notifier.send("This message is sent to slack first then to facebook and finally to email");
    }
}
