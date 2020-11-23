package languagebasic;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayPackingTest {

    private static final String EMPTY_ARRAY = "emptyArray";
    private static final String NORMAL_ARRAY = "normalArray";
    private static final String SINGLE_ELEMENT_ARRAY = "singleElementArray";
    private static final String LONG_ARRAYS = "arrayLonger";


    @DataProvider(name = EMPTY_ARRAY)
    public Object[][] emptyArrayProvider() {
        return new Object[][]{
                {new int[]{}}
        };
    }

    private ArrayPacking arrayPacking = new ArrayPacking();

    @DataProvider(name = NORMAL_ARRAY)
    public Object[][] normalArrayProvider() {
        return new Object[][]{
                {new int[]{24, 85, 0}}
        };
    }

    @DataProvider(name = SINGLE_ELEMENT_ARRAY)
    public Object[][] singleElementArrayProvider() {
        return new Object[][]{
                {new int[]{121}}
        };
    }

    @DataProvider(name = LONG_ARRAYS)
    public Object[][] allArrayProvider() {
        return new Object[][]{
                {new int[]{24, 85, 0, 6, 8, 8}}
        };
    }

    @Test(dataProvider = LONG_ARRAYS)
    public void getRandomRoster_negativeSize_returnEmpty(int[] availableNumbers) {
        int result = arrayPacking.arrayPacking(availableNumbers);
        Assert.assertEquals(result, -1);
    }

    @Test(dataProvider = NORMAL_ARRAY)
    public void getArrayPacking_normalArray_returnTheIntegerNumberMore2Items(int[] availableNumbers) {
        int result = arrayPacking.arrayPacking(availableNumbers);
        Assert.assertEquals(result, 21784);
    }

    @Test(dataProvider = SINGLE_ELEMENT_ARRAY)
    public void getArrayPacking_singleElementArray_returnTheIntegerNumberWith1Items(int[] availableNumbers) {
        int result = arrayPacking.arrayPacking(availableNumbers);
        Assert.assertEquals(result , 121);
    }

    @Test(dataProvider = EMPTY_ARRAY)
    public void getArrayPacking_emptyArray_returnEmpty(int[] availableNumbers) {
        int result = arrayPacking.arrayPacking(availableNumbers);
        Assert.assertEquals(result, -1);
    }
}