package commondesignpatterns.creationalpatterns.abstractfactory;

public class ClassicChair implements Chair {

    @Override
    public String getType() {
        return "Classic";
    }
}
