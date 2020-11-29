package languagebasic;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayPackingTest {

    private static final String OUT_BOUND_ITEM_ARRAY = "outBoundItemArray";
    private static final String NORMAL_ARRAY = "normalArray";
    private static final String SINGLE_ELEMENT_ARRAY = "singleElementArray";
    private static final String EDGE_ARRAYS = "edgeArray";


    @DataProvider(name = OUT_BOUND_ITEM_ARRAY)
    public Object[][] outBoundItemArrayProvider() {
        return new Object[][]{
                {new int[]{1, 85, 256}},
                {new int[]{1, -1, 7}}
        };
    }

    @DataProvider(name = EDGE_ARRAYS)
    public Object[][] edgeArrayProvider() {
        return new Object[][]{
                {new int[]{}},
                {new int[]{24, 85, 0, 6, 8, 8}}
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

    @Test(dataProvider = EDGE_ARRAYS)
    public void getRandomRoster_negativeSize_returnEmpty(int[] availableNumbers) {
        try {
            arrayPacking.arrayPacking(availableNumbers);
        }catch (CustomException ex){
            Assert.assertEquals(ex.getMessage(), "The input break the rule array.length between 1 to 4");
        }
    }

    @Test(dataProvider = OUT_BOUND_ITEM_ARRAY)
    public void getRandomRoster_outBoundItems(int[] availableNumbers) {
        try {
            arrayPacking.arrayPacking(availableNumbers);
        }catch (CustomException ex){
            Assert.assertEquals(ex.getMessage(), "Existing a item in array break the rule as value between 0 to 255");
        }
    }

    @Test(dataProvider = NORMAL_ARRAY)
    public void getArrayPacking_normalArray_returnTheIntegerNumberMore2Items(int[] availableNumbers) throws CustomException {
        int result = arrayPacking.arrayPacking(availableNumbers);
        Assert.assertEquals(result, 21784);
    }

    @Test(dataProvider = SINGLE_ELEMENT_ARRAY)
    public void getArrayPacking_singleElementArray_returnTheIntegerNumberWith1Items(int[] availableNumbers) throws CustomException {
        int result = arrayPacking.arrayPacking(availableNumbers);
        Assert.assertEquals(result , 121);
    }
}