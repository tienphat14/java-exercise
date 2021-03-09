package coaching.validation.rules;

import java.lang.annotation.Annotation;

public interface ValidationRule<T extends Annotation> {
    boolean isValid(T annotation, String fieldName, Object fieldData);
    String getMessage(T annotation);
    Class<T> getAnnotationClass();
}
