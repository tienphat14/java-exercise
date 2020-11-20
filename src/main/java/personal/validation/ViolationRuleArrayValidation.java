package personal.validation;

import personal.InvalidValueException;
import personal.UnSupportLengthSizeException;
import personal.models.ArrayViolationCriteria;

import java.util.Arrays;

public class ViolationRuleArrayValidation {
    private final ArrayViolationCriteria violationCriteria;

    public ViolationRuleArrayValidation(ArrayViolationCriteria violationCriteria) {
        this.violationCriteria = violationCriteria;
    }

    public void validateViolationRules(int[] array) {
        int lengthArgument = array.length;

        boolean isInvalidValueAvailable = Arrays.stream(array).anyMatch(i -> (i < violationCriteria.getMinValue()) || (i > violationCriteria.getMaxValue()));

        if (isInvalidValueAvailable)
            throw new InvalidValueException("The value inside is not match with violation rule");
        if ((lengthArgument >= violationCriteria.getMaxLength()) || (lengthArgument < violationCriteria.getMinLength()))
            throw new UnSupportLengthSizeException("The length of argument is not match with violation rule");
    }
}
