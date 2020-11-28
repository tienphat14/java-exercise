package languagebasic;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ArrayPreviousLessTest {
    private static final String NORMAL_ARRAY = "normalArray";
    private static final String EMPTY_ARRAY = "emptyArray";
    private static final String EXCEPTION_ARRAY = "exceptionArray";

    ArrayPreviousLess arrayPreviousLess = new ArrayPreviousLess();

    @DataProvider(name = EXCEPTION_ARRAY)
    public Object[][] exceptionArrayProvider() {
        return new Object[][]{
                {new int[]{1,2}},
                {new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}}
        };
    }

    @DataProvider(name = EMPTY_ARRAY)
    public Object[][] emptyArrayProvider() {
        return new Object[][]{
                {new int[]{}}
        };
    }

    @DataProvider(name = NORMAL_ARRAY)
    public Object[][] normalArrayProvider() {
        return new Object[][]{
                {new int[]{1, 2, 10, 4, 5, 10, 7, 8, 9, 10}}
        };
    }

    @Test(dataProvider = NORMAL_ARRAY)
    public void getPreviousLess_normalArray(int[] availableNumbers) throws ArrayPreviousLess.CustomException {
        int[] results = arrayPreviousLess.arrayPreviousLess(availableNumbers);
        Assert.assertTrue(Arrays.equals(results, new int[]{-1, 1, 2, 2, 4, 5, 5, 7, 8, 9}));

    }

    @Test(dataProvider = EMPTY_ARRAY)
    public void getPreviousLess_emptyArray(int[] availableNumbers){
        try {
            arrayPreviousLess.arrayPreviousLess(availableNumbers);
        } catch (ArrayPreviousLess.CustomException e) {
            Assert.assertTrue(e.getMessage().contains("The input break the rule items.length between 3 to 15"));
            return;
        }
        Assert.fail("The message errors are not expected results.");
    }

    @Test(dataProvider = EXCEPTION_ARRAY)
    public void getPreviousLess_exceptionArray(int[] availableNumbers){
        try {
            arrayPreviousLess.arrayPreviousLess(availableNumbers);
        } catch (ArrayPreviousLess.CustomException e) {
            Assert.assertTrue(e.getMessage().contains("The input break the rule items.length between 3 to 15"));
            return;
        }
        Assert.fail("The message errors are not expected results.");
    }
}