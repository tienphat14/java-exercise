package commondesignpatterns.creationalpatterns.abstractfactory;

public class ThreeLegsTable implements Table {

    @Override
    public int legCount() {
        return 3;
    }
}
