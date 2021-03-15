package springprofiles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProfileConfiguration.class)
@ActiveProfiles("prod")
public class PrintComponentTest {

    private final Logger LOGGER = LoggerFactory.getLogger(PrintComponentTest.class);

    @Autowired
    private Environment environment;

    @Autowired
    private PrintComponent printComponent;

    @Test
    public void test() {
        LOGGER.info("Active profiles:");
        for (String profileName: environment.getActiveProfiles()) {
            LOGGER.info("{} ", profileName);
        }
        LOGGER.info("Default profiles:");
        for (String profileName: environment.getDefaultProfiles()) {
            LOGGER.info("{} ", profileName);
        }
        printComponent.print();
    }
}
