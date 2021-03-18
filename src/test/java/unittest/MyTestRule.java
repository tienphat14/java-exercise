package unittest;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTestRule implements TestRule {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyTestRule.class);
    private String message;

    public MyTestRule(String message) {
        this.message = message;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                before();
                base.evaluate();
                after();
            }
        };
    }

    private void before() {
        LOGGER.info("Inside MyTestRule before method, message: {}", message);
    }

    private void after() {
        LOGGER.info("Inside MyTestRule after method, message: {}", message);
    }
}
