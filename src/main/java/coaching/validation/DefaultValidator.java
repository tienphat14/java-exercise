package coaching.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementing the validation
 */

public class DefaultValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultValidator.class);
    /**
     * {@inheritDoc}
     *
     * @param data Input data
     * @return
     */
    @Override
    public Collection<Violation> validate(Object data) throws IllegalAccessException {
        if (Objects.isNull(data)) {
            throw new IllegalArgumentException();
        }
        Collection<Violation> violations = new ArrayList<>();

        for (Field field : data.getClass().getDeclaredFields()) {
            Violation violation = new Violation();
            boolean fieldAccessible = field.isAccessible();
            field.setAccessible(true);
            violation.setFieldName(field.getName());
            violation.setInvalidValue(field.get(data));

            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation.annotationType() == NotNull.class) {
                    NotNull notNull = (NotNull) annotation;
                    if (Objects.isNull(field.get(data))) {
                        violation.setMessages(notNull.message());
                    }
                } else if (annotation.annotationType() == Size.class) {
                    Size size = (Size) annotation;
                    if (field.get(data) instanceof String) {
                        if (field.get(data).toString().length() < size.min() || field.get(data).toString().length() > size.max()) {
                            LOGGER.info("Data: " + field.get(data));
                            LOGGER.info("Length: " + field.get(data).toString().length());
                            violation.setMessages(size.message());
                        }
                    } else if (field.get(data) instanceof Integer) {
                        if (((Integer) field.get(data)).intValue() < size.min() || ((Integer) field.get(data)).intValue() > size.max()) {
                            LOGGER.info("Value: " + field.get(data));
                            violation.setMessages(size.message());
                        }
                    }
                } else if (annotation.annotationType() == Regex.class) {
                    Regex regex = (Regex) annotation;
                    LOGGER.info("Data: " + field.get(data));
                    Pattern pattern = Pattern.compile(regex.pattern());
                    LOGGER.info("Pattern: " + regex.pattern());
                    Matcher matcher = pattern.matcher(field.get(data).toString());
                    boolean isMatched = matcher.matches();
                    LOGGER.info("Is matched: " + isMatched);
                    if (!isMatched) {
                        violation.setMessages(regex.message());
                    }
                }
            }
            field.setAccessible(fieldAccessible);
            violations.add(violation);
        }
        return violations;
    }
}
