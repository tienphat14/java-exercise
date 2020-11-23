package languagebasic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayPreviousLessTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayPreviousLessTest.class);
    private static final String INVALID_INPUT = "invalidInput";
    private static final String VALID_INPUT = "validInput";
    private ArrayPreviousLess arrayPreviousLess = new ArrayPreviousLess();

    @DataProvider(name = VALID_INPUT)
    public Object[][] validInputDataProvider() {
        return new Object[][]{
                {new int[]{3, 5, 2, 4, 5},
                        new int[]{-1, 3, -1, 2, 4}},
                {new int[]{2, 2, 1, 3, 4, 5, 5, 3},
                        new int[]{-1, -1, -1, 1, 3, 4, 4, 1}},
                {new int[]{3, 2, 1},
                        new int[]{-1, -1, -1}},
                {new int[]{100, 101, 102},
                        new int[]{-1, 100, 101}},
                {new int[]{7, 7, 8, 3, 4, 4, 2, 5, 6, 7, 7},
                        new int[]{-1, -1, 7, -1, 3, 3, -1, 2, 5, 6, 6}},
                {new int[]{68, 135, 101, 170, 125},
                        new int[]{-1, 68, 68, 101, 101}},
                {new int[]{38, 170, 56},
                        new int[]{-1, 38, 38}},
                {new int[]{146, 32, 70, 156, 170, 107, 1},
                        new int[]{-1, -1, 32, 70, 156, 70, -1}},
                {new int[]{177, 9, 10, 153, 84, 194, 115, 123, 14, 31, 73},
                        new int[]{-1, -1, 9, 10, 10, 84, 84, 115, 10, 14, 31}},
                {new int[]{34, 54, 70, 189, 8, 76, 162, 172, 73, 40, 119, 102, 93, 5, 175},
                        new int[]{-1, 34, 54, 70, -1, 8, 76, 162, 8, 8, 40, 40, 40, -1, 5}},
                {new int[]{200, 200, 145, 12, 200, 50, 130, 170, 80, 60, 50},
                        new int[]{-1, -1, -1, -1, 12, 12, 50, 130, 50, 50, 12}}
        };
    }

    @DataProvider(name = INVALID_INPUT)
    public Object[][] invalidInputDataProvider() {
        return new Object[][]{
                {new int[]{}},
                {new int[]{1, 2}},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}},
                {new int[]{0, 1, 2, 3}},
                {new int[]{1, 0, 2, 3}},
                {new int[]{1, 2, 200, 201}},
                {new int[]{1, 2, 201, 200}},
        };
    }

    @Test(dataProvider = INVALID_INPUT, expectedExceptions = CustomException.class)
    public void arrayPreviousLess_invalidInput_throwCustomException(int[] array) throws CustomException {
        arrayPreviousLess.arrayPreviousLess(array);
    }

    @Test(dataProvider = VALID_INPUT)
    public void arrayPreviousLess_validInput_returnExpectedResult(int[] array, int[] expect) throws CustomException {
        Assert.assertEquals(arrayPreviousLess.arrayPreviousLess(array), expect);
    }
}