package commondesignpatterns.creationalpatterns.abstractfactory;

public class ModernFurnitureFactory implements AbstractFactory {

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ThreeLegsTable();
    }
}
