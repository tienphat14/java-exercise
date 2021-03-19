package commondesignpatterns.structuralpatterns.proxy;

public class ExpensiveObjectProxy implements ExpensiveObject{
    private ExpensiveObject object;

    @Override
    public void process() {
        if(object == null) {
            object = new ExpensiveObjectImpl();
        }
        object.process();
    }
}
