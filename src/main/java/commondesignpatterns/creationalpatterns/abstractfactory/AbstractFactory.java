package commondesignpatterns.creationalpatterns.abstractfactory;

public interface AbstractFactory {
    Chair createChair();
    Table createTable();
}