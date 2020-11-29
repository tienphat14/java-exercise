package languagebasic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayPackingTest {
    //TODO: Write tests for your code

    private static final String VALID_ARRAY = "validArray";
    private static final String INVALID_ARRAY = "invalidArray";
    private static final String TOO_LARGE_INTEGER_ARRAY = "tooLargeIntegerArray";
    private ArrayPacking arrayPacking = new ArrayPacking();

    @DataProvider(name = VALID_ARRAY)
    public Object[][] validArrayProvider() {
        return new Object[][]{
                {new int[]{10, 100, 255}}
        };
    }

    @DataProvider(name = INVALID_ARRAY)
    public Object[][] invalidArrayProvider() {
        return new Object[][]{
                {new int[]{}},
                {new int[]{-1, -10}},
                {new int[]{256, 300, 500}},
                {new int[]{2, 100, 150, 250, 255}}
        };
    }

    @DataProvider(name = TOO_LARGE_INTEGER_ARRAY)
    public Object[][] tooLargeIntegerArrayProvider() {
        return new Object[][]{
                {new int[]{100, 150, 250, 255}},
        };
    }

    @Test(dataProvider = VALID_ARRAY)
    public void arrayPacking_validArray_returnPackedInteger(int[] array) throws ArrayPacking.CustomException {
           int result = arrayPacking.arrayPacking(array);
           Assert.assertEquals(result,16737290);
    }

    @Test(dataProvider = INVALID_ARRAY)
    public void arrayPacking_invalidArray_returnException(int[] array) {
        try {
            arrayPacking.arrayPacking(array);
        } catch (ArrayPacking.CustomException c) {
            System.out.println(c.getMessage());
        }
    }

    @Test(dataProvider = TOO_LARGE_INTEGER_ARRAY)
    public void arrayPacking_tooLargeIntegerArray_returnException(int[] array) {
        try {
            arrayPacking.arrayPacking(array);
        } catch (ArrayPacking.CustomException c) {
            System.out.println(c.getMessage());
        }
    }
}