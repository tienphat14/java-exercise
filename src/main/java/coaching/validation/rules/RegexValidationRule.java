package coaching.validation.rules;

import coaching.validation.Regex;

public class RegexValidationRule implements ValidationRule<Regex> {

    @Override
    public boolean isValid(Regex annotation, String fieldName, Object fieldData) {
        return String.valueOf(fieldData).matches(annotation.pattern());
    }

    @Override
    public String getMessage(Regex annotation) {
        return annotation.message();
    }

    @Override
    public Class<Regex> getAnnotationClass() {
        return Regex.class;
    }
}
