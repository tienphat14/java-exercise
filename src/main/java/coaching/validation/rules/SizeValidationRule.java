package coaching.validation.rules;

import coaching.validation.Size;

public class SizeValidationRule implements ValidationRule<Size> {

    @Override
    public boolean isValid(Size annotation, String fieldName, Object fieldData) {
        int length = 0;
        if (fieldData instanceof Integer) {
            length = (int) fieldData;
        } else if (fieldData instanceof String) {
            length = String.valueOf(fieldData).length();
        }
        return (length >= annotation.min() && length <= annotation.max());
    }

    @Override
    public String getMessage(Size annotation) {
        return annotation.message();
    }

    @Override
    public Class<Size> getAnnotationClass() {
        return Size.class;
    }
}
