package commondesignpatterns.structuralpatterns.proxy;

public class ProxyExample {
    public static void main(String[] args) {
        ExpensiveObject object = new ExpensiveObjectProxy();
        object.process();
        object.process();
    }
}
