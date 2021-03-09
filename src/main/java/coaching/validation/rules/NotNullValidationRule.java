package coaching.validation.rules;

import coaching.validation.NotNull;

import java.util.Objects;

public class NotNullValidationRule implements ValidationRule<NotNull> {

    @Override
    public boolean isValid(NotNull annotation, String fieldName, Object fieldData) {
        return Objects.nonNull(fieldData);
    }

    @Override
    public String getMessage(NotNull annotation) {
        return annotation.message();
    }

    @Override
    public Class<NotNull> getAnnotationClass() {
        return NotNull.class;
    }
}
