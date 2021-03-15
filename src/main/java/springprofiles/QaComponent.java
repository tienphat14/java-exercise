package springprofiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("qa")
public class QaComponent implements PrintComponent {
    private final Logger LOGGER = LoggerFactory.getLogger(QaComponent.class);
    @Override
    public void print() {
        LOGGER.info("QaComponent");
    }
}
