package springprofiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevComponent implements PrintComponent {
    private final Logger LOGGER = LoggerFactory.getLogger(DevComponent.class);
    @Override
    public void print() {
        LOGGER.info("DevComponent");
    }
}
