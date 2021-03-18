package commondesignpatterns.structuralpatterns.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpensiveObjectImpl implements ExpensiveObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpensiveObjectImpl.class);

    public ExpensiveObjectImpl() {
        heavyInitialConfiguration();
    }

    @Override
    public void process() {
        LOGGER.info("Processing complete");
    }

    private void heavyInitialConfiguration() {
        LOGGER.info("Loading initial configuration...");
    }
}