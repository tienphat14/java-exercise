package commondesignpatterns.creationalpatterns.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractFactoryExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractFactoryExample.class);

    public static void main(String[] args) {
        AbstractFactory abstractFactory = FactoryProvider.getFactory("classic");
        Chair chair = abstractFactory.createChair();
        Table table = abstractFactory.createTable();
        LOGGER.info("Classic furniture: {} chair, {} legs table", chair.getType(), table.legCount());
    }
}
