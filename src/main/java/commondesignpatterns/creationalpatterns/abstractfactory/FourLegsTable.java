package commondesignpatterns.creationalpatterns.abstractfactory;

public class FourLegsTable implements Table {

    @Override
    public int legCount() {
        return 4;
    }
}
