package coaching.validation;

import coaching.validation.rules.NotNullValidationRule;
import coaching.validation.rules.RegexValidationRule;
import coaching.validation.rules.SizeValidationRule;
import coaching.validation.rules.ValidationRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DefaultValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultValidator.class);
    private final Map<Class<? extends Annotation>, ValidationRule<? extends Annotation>> ruleMap;

    public DefaultValidator() {
        this.ruleMap = new HashMap<>();
        ruleMap.put(NotNull.class, new NotNullValidationRule());
        ruleMap.put(Size.class, new SizeValidationRule());
        ruleMap.put(Regex.class, new RegexValidationRule());
    }

    public DefaultValidator(List<ValidationRule<? extends Annotation>> validationRuleList) {
        this.ruleMap = validationRuleList.stream().collect(Collectors.toMap(ValidationRule::getAnnotationClass, Function.identity()));
    }

    /**
     * {@inheritDoc}
     *
     * @param target Input data
     * @return
     */
    @Override
    public Collection<Violation> validate(Object target) throws IllegalAccessException {
        if (Objects.isNull(target)) {
            throw new IllegalArgumentException("Cannot be null");
        }

        List<Violation> violationCollection = new ArrayList<>();
        for (Field field : target.getClass().getDeclaredFields()) {
            boolean fieldAccessible = field.isAccessible();
            field.setAccessible(true);
            validateField(target, field).ifPresent(violationCollection::add);
            field.setAccessible(fieldAccessible);
        }

        return violationCollection;
    }

    private Optional<Violation> validateField(Object target, Field field) throws IllegalAccessException {
        List<String> messages = new ArrayList<>();
        String fieldName = field.getName();
        Object fieldData = field.get(target);
        for (Annotation annotation : field.getDeclaredAnnotations()) {
            Class annotationType = annotation.annotationType();
            if (ruleMap.containsKey(annotationType)) {
                ValidationRule rule = ruleMap.get(annotationType);
                if (!rule.isValid(annotation, fieldName, fieldData)) {
                    messages.add(rule.getMessage(annotation));
                }
            }
        }
        if (messages.isEmpty()) {
            return Optional.empty();
        }
        Violation violation = new Violation();
        violation.setFieldName(fieldName);
        violation.setInvalidValue(fieldData);
        violation.setMessages(messages);
        return Optional.of(violation);
    }
}
