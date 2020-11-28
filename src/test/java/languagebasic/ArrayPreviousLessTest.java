package languagebasic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import personal.InvalidValueException;
import personal.UnSupportLengthSizeException;
import personal.models.ArrayViolationCriteria;

import java.util.Arrays;

public class ArrayPreviousLessTest {
    private ArrayPreviousLess arrayPreviousLess;

    @Before
    public void init() {
        //Init violation criteria
        ArrayViolationCriteria violationCriteria = ArrayViolationCriteria.builder()
                .minLength(3)
                .maxLength(15)
                .minValue(1)
                .maxValue(200)
                .build();
        arrayPreviousLess = new ArrayPreviousLess(violationCriteria);
    }

    @Test
    public void enterValidArray() {
        int[] dataTest = new int[]{3, 5, 2, 4, 5};
        Assert.assertEquals("[-1, 3, -1, 2, 4]", Arrays.toString(arrayPreviousLess.arrayPreviousLess(dataTest)));
    }

    @Test
    public void enterArrayLessThanMinLength() {
        int[] dataTest = new int[]{7,3};
        try {
            arrayPreviousLess.arrayPreviousLess(dataTest);
            Assert.fail("No Exception when entering invalid length");
        } catch (UnSupportLengthSizeException exception) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void enterArrayGreaterThanMaxLength() {
        int[] dataTest = new int[]{7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3
                ,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3
                ,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3,7,3};
        try {
            arrayPreviousLess.arrayPreviousLess(dataTest);
            Assert.fail("No Exception when entering invalid length");
        } catch (UnSupportLengthSizeException exception) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void enterArrayHavingInvalidMinValue() {
        int[] dataTest = new int[]{0, 5, 2, 4, 5};
        try {
            arrayPreviousLess.arrayPreviousLess(dataTest);
            Assert.fail("No Exception when entering invalid value");
        } catch (InvalidValueException exception) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void enterArrayHavingInvalidMaxValue() {
        int[] dataTest = new int[]{1, 5, 2, 4, 201};
        try {
            arrayPreviousLess.arrayPreviousLess(dataTest);
            Assert.fail("No Exception when entering invalid value");
        } catch (InvalidValueException exception) {
            Assert.assertTrue(true);
        }
    }

}