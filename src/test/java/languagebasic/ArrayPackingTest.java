package languagebasic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import personal.InvalidValueException;
import personal.UnSupportLengthSizeException;
import personal.models.ArrayViolationCriteria;

public class ArrayPackingTest {
    private ArrayPacking arrayPacking;

    @Before
    public void init() {
        //Init violation criteria
        ArrayViolationCriteria violationCriteria = ArrayViolationCriteria.builder()
                .minLength(0)
                .maxLength(5)
                .minValue(0)
                .maxValue(256)
                .build();
        arrayPacking = new ArrayPacking(violationCriteria);
    }

    @Test
    public void enterValidArray() {
        int[] dataTest = new int[]{24, 85, 0};
        int valueConvert = arrayPacking.arrayPacking(dataTest);
        Assert.assertEquals(21784, valueConvert);
    }

    @Test
    public void enterArrayWithLengthGreaterThanViolationRules() {
        int[] dataTest = new int[]{24, 85, 0, 9, 19};
        try {
            arrayPacking.arrayPacking(dataTest);
            Assert.fail("No Exception when entering invalid array length");
        } catch (UnSupportLengthSizeException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void enterEmptyArray() {
        int[] dataTest = new int[]{};
        int valueConvert = arrayPacking.arrayPacking(dataTest);
        Assert.assertEquals(0, valueConvert);
    }

    @Test
    public void enterArrayHavingNegativeNumber() {
        int[] dataTest = new int[]{24, 85, 0, -9};
        try {
            arrayPacking.arrayPacking(dataTest);
            Assert.fail("No Exception when entering invalid value");
        } catch (InvalidValueException e) {
            Assert.assertTrue(true);
        }
    }
}