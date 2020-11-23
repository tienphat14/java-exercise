package languagebasic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayPreviousLessTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayPreviousLessTest.class);
    private static final String EMPTY_ARRAY = "emptyArray";
    private static final String SINGLE_ZERO_ARRAY = "singleZeroArray";
    private static final String SINGLE_NEGATIVE_ARRAY = "singleNegativeArray";
    private static final String OVER_ELEMENTS_ARRAY = "overElementArray";
    private static final String NORMAL_ARRAY = "normalArray";
    private ArrayPreviousLess arrayPreviousLess = new ArrayPreviousLess();

    @DataProvider(name = EMPTY_ARRAY)
    public Object[][] emptyArrayProvider() {
        return new Object[][]{
                {new int[]{}}
        };
    }

    @DataProvider(name = OVER_ELEMENTS_ARRAY)
    public Object[][] overArrayProvider() {
        return new Object[][]{
                {new int[]{24, 85, 0, 999, 222}}
        };
    }

    @DataProvider(name = SINGLE_ZERO_ARRAY)
    public Object[][] singleElementArrayProvider() {
        return new Object[][]{
                {new int[]{0}}
        };
    }

    @DataProvider(name = SINGLE_NEGATIVE_ARRAY)
    public Object[][] singleNegativeArrayProvider() {
        return new Object[][]{
                {new int[]{-3}}
        };
    }

    @DataProvider(name = NORMAL_ARRAY)
    public Object[][] normalArrayProvider() {
        return new Object[][]{
                {new int[]{3, 5, 2, 4, 5}}
        };
    }

    @Test(dataProvider = NORMAL_ARRAY)
    public void getArrayPreviousLess_normalArray_returnArrayComputed(int[] array){
        int[] result = arrayPreviousLess.arrayPreviousLess(array);
        Assert.assertEquals(result, new int[]{-1, 3, -1, 2, 4});
    }

    @Test(dataProvider = SINGLE_ZERO_ARRAY, expectedExceptions = InputViolatesRulesException.class)
    public void getArrayPreviousLess_singleArray_returnCustomException(int[] array){
        int[] result = arrayPreviousLess.arrayPreviousLess(array);
    }
}