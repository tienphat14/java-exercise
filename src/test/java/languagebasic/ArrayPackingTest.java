package languagebasic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayPackingTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayPackingTest.class);
    private static final String INVALID_INPUT = "invalidInput";
    private static final String VALID_INPUT = "validInput";
    private ArrayPacking arrayPacking = new ArrayPacking();

    @DataProvider(name = VALID_INPUT)
    public Object[][] validInputDataProvider() {
        return new Object[][]{
                {new int[]{24, 85, 0}, 21784},
                {new int[]{23, 45, 39}, 2567447},
                {new int[]{1, 2, 4, 8}, 134480385},
                {new int[]{5}, 5},
                {new int[]{187, 99, 42, 43}, 724198331},
                {new int[]{0}, 0},
                {new int[]{207, 78, 212, 28}, 483675855},
                {new int[]{111, 8, 150}, 9832559},
                {new int[]{242, 30}, 7922},
                {new int[]{255, 255, 255, 127}, 2147483647},
        };
    }

    @DataProvider(name = INVALID_INPUT)
    public Object[][] invalidInputDataProvider() {
        return new Object[][]{
                {new int[]{}},
                {new int[]{1, 2, 3, 4, 5}},
                {new int[]{-1, 0, 1, 2}},
                {new int[]{0, -1, 1, 2}},
                {new int[]{0, 1, 2, 256}},
                {new int[]{0, 1, 256, 2}},
        };
    }

    @Test(dataProvider = INVALID_INPUT, expectedExceptions = CustomException.class)
    public void arrayPacking_invalidInput_throwCustomException(int[] array) throws CustomException {
        arrayPacking.arrayPacking(array);
    }

    @Test(dataProvider = VALID_INPUT)
    public void arrayPacking_validInput_returnExpectedResult(int[] array, int expect) throws CustomException {
        Assert.assertEquals(arrayPacking.arrayPacking(array), expect);
    }
}