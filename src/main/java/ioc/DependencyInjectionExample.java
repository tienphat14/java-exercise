package ioc;

public class DependencyInjectionExample {

    private Client client;

    public DependencyInjectionExample() {
        client = new Client(new FirstDependencyImpl());
        client.setSecondDependency(new SecondDependencyImpl());
    }

    public class Client {
        private FirstDependency firstDependency;
        private SecondDependency secondDependency;

        public Client(FirstDependency firstDependency) {
            this.firstDependency = firstDependency;
        }

        public void setSecondDependency(SecondDependency secondDependency) {
            this.secondDependency = secondDependency;
        }
    }

    public interface FirstDependency {}
    public class FirstDependencyImpl implements FirstDependency {}
    public interface SecondDependency {}
    public class SecondDependencyImpl implements SecondDependency {}
}
