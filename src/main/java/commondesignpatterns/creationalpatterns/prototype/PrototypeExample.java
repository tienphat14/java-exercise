package commondesignpatterns.creationalpatterns.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrototypeExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrototypeExample.class);

    public static void main(String[] args) {
        Student genius = new Student();
        genius.setName("Hero");
        genius.setAge(6);
        genius.setGpa(10);

        Student mimicker = genius.clone();
        LOGGER.info("Mimicker: {}", mimicker);
    }
}
