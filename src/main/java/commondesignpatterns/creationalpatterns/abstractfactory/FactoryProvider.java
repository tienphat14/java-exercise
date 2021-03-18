package commondesignpatterns.creationalpatterns.abstractfactory;

public class FactoryProvider {
    public static AbstractFactory getFactory(String choice){
        if("Mordern".equalsIgnoreCase(choice)){
            return new ModernFurnitureFactory();
        }
        else if("Classic".equalsIgnoreCase(choice)){
            return new ClassicFurnitureFactory();
        }
        return null;
    }
}
