package languagebasic;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class OverlappingIntervalPairsTest {

    private static final String NORMAL_ARRAY = "normalArray";

    OverlappingIntervalPairs overlappingIntervalPairs = new OverlappingIntervalPairs();

    @DataProvider(name = NORMAL_ARRAY)
    public Object[][] normalArrayProvider() {
        return new Object[][]{
                {new int[][]{{11, 15},{3, 9},{1, 4},{15, 18}, {13, 16}}}
        };
    }

    @Test(dataProvider = NORMAL_ARRAY)
    public void getArrayPacking_normalArray_returnTheIntegerNumberMore2Items(int[][] availableNumbers) {
        int[][][] result  = overlappingIntervalPairs.getTheCoupleArrayOverlapRange(availableNumbers);
        int[][][] expectedResult = new int[][][]{{{11,15},{15,18}},{{11, 15},{13, 16}},{{3, 9},{1, 4}},{{15, 18},{13, 16}}};
        Assert.assertTrue(Arrays.deepEquals(expectedResult, result));
    }
}
