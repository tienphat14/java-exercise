package commondesignpatterns.creationalpatterns.abstractfactory;

public class ClassicFurnitureFactory implements AbstractFactory {

    @Override
    public Chair createChair() {
        return new ClassicChair();
    }

    @Override
    public Table createTable() {
        return new FourLegsTable();
    }
}
