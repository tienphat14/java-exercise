package languagebasic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayPackingTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayPackingTest.class);
    private static final String EMPTY_ARRAY = "emptyArray";
    private static final String SINGLE_MAXIMUM_ARRAY = "singleElementArray";
    private static final String SINGLE_NEGATIVE_ARRAY = "singleNegativeArray";
    private static final String OVER_ELEMENTS_ARRAY = "overElementArray";
    private static final String NORMAL_ARRAY = "normalArray";
    private ArrayPacking arrayPacking = new ArrayPacking();

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

    @DataProvider(name = SINGLE_MAXIMUM_ARRAY)
    public Object[][] singleElementArrayProvider() {
        return new Object[][]{
                {new int[]{2147483647}}
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
                {new int[]{24, 85, 0}}
        };
    }

    @Test(dataProvider = NORMAL_ARRAY)
    public void getArrayPacking_normalArray_returnObtainedIntegerPacked(int[] array){
        int result = arrayPacking.arrayPacking(array);
        Assert.assertEquals(result, 21784);
    }

    @Test(dataProvider = EMPTY_ARRAY)
    public void getArrayPacking_emptyArray_returnMessageRequiredArrayLength(int[] array){
        int result = arrayPacking.arrayPacking(array);
        Assert.assertEquals(result, 0); //return 0 = catch message
    }

    @Test(dataProvider = OVER_ELEMENTS_ARRAY)
    public void getArrayPacking_overElementsArray_returnMessageRequiredArrayLength(int[] array){
        int result = arrayPacking.arrayPacking(array);
        Assert.assertEquals(result, 0); //return 0 = catch message
    }

    @Test(dataProvider = SINGLE_MAXIMUM_ARRAY)
    public void getArrayPacking_singleArray_returnSingleObtainedIntegerPacked(int[] array){
        int result = arrayPacking.arrayPacking(array);
        Assert.assertEquals(result, 255); //return 255
    }

    @Test(dataProvider = SINGLE_NEGATIVE_ARRAY)
    public void getArrayPacking_negativeArray_returnSingleObtainedIntegerPacked(int[] array){
        int result = arrayPacking.arrayPacking(array);
        Assert.assertEquals(result, 0); //return 0 = catch message
    }
}