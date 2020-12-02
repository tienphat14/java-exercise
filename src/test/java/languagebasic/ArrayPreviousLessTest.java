package languagebasic;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ArrayPreviousLessTest {
    private static final String NORMAL_ARRAY = "normalArray";
    private static final String ALL_SAME_ARRAY = "allSameArray";
        private static final String EMPTY_ARRAY = "emptyArray";
    private static final String EXCEPTION_ARRAY = "exceptionArray";
    private static final String EXCEPTION_VALUE_BREAK_ARRAY = "itemBreakRuleArray";


    ArrayPreviousLess arrayPreviousLess = new ArrayPreviousLess();

    @DataProvider(name = EXCEPTION_ARRAY)
    public Object[][] exceptionArrayProvider() {
        return new Object[][]{
                {new int[]{1,2}},
                {new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}}
        };
    }

    @DataProvider(name = EXCEPTION_VALUE_BREAK_ARRAY)
    public Object[][] itemBreakRuleArrayProvider() {
        return new Object[][]{
                {new int[]{1, 255, 6, 7}},
                {new int[]{-1, 255, 6, 7}}
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
                {new int[]{1, 2, 10, 4, 5, 10, 7, 8, 9, 10}},
        };
    }

    @DataProvider(name = ALL_SAME_ARRAY)
    public Object[][] allSameArrayProvider() {
        return new Object[][]{
                {new int[]{5, 5, 5, 5, 5}},
        };
    }

    @Test(dataProvider = NORMAL_ARRAY)
    public void getPreviousLess_normalArray(int[] availableNumbers) throws CustomException {
        int[] results = arrayPreviousLess.arrayPreviousLess(availableNumbers);
        Assert.assertTrue(Arrays.equals(results, new int[]{-1, 1, 2, 2, 4, 5, 5, 7, 8, 9}));

    }

    @Test(dataProvider = ALL_SAME_ARRAY)
    public void getPreviousLess_allSameArray(int[] availableNumbers) throws CustomException {
        int[] results = arrayPreviousLess.arrayPreviousLess(availableNumbers);
        Assert.assertTrue(Arrays.equals(results, new int[]{-1, -1, -1, -1, -1}));
    }

    @Test(dataProvider = EMPTY_ARRAY)
    public void getPreviousLess_emptyArray(int[] availableNumbers){
        try {
            arrayPreviousLess.arrayPreviousLess(availableNumbers);
        } catch (CustomException e) {
            Assert.assertTrue(e.getMessage().contains("The input break the rule items.length between 3 to 15"));
            return;
        }
        Assert.fail("The message errors are not expected results.");
    }

    @Test(dataProvider = EXCEPTION_ARRAY)
    public void getPreviousLess_exceptionArray(int[] availableNumbers){
        try {
            arrayPreviousLess.arrayPreviousLess(availableNumbers);
        } catch (CustomException e) {
            Assert.assertTrue(e.getMessage().contains("The input break the rule items.length between 3 to 15"));
            return;
        }
        Assert.fail("The message errors are not expected results.");
    }

    @Test(dataProvider = EXCEPTION_VALUE_BREAK_ARRAY)
    public void getPreviousLess_itemBreakValueArray(int[] availableNumbers){
        try {
            arrayPreviousLess.arrayPreviousLess(availableNumbers);
        } catch (CustomException e) {
            Assert.assertTrue(e.getMessage().contains("The input break the rule item value between 1 to 200"));
            return;
        }
        Assert.fail("The message errors are not expected results.");
    }

}