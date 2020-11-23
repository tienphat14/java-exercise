package languagebasic;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayPackingTest {

    private static final String NORMAL_ARRAY = "normalArray";

    private ArrayPacking arrayPacking = new ArrayPacking();

    @DataProvider(name = NORMAL_ARRAY)
    public Object[][] normalArrayProvider() {
        return new Object[][]{
                {new int[]{24, 85, 0}}
        };
    }

    @Test(dataProvider = NORMAL_ARRAY)
    public void getArrayPacking_normalArray_returnTheIntegerNumber(int[] availableNumbers) {
        int result = arrayPacking.arrayPacking(availableNumbers);
        Assert.assertEquals(result, 21784);
    }
}