package languagebasic;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class OverlappingIntervalPairsTest {

    private static final String NORMAL_ARRAY = "normalArray";
    private static final String NON_EXISTING_OVERLAP_ARRAY = "noneOverlapArray";
    private static final String MULTI = "Multi";

    OverlappingIntervalPairs overlappingIntervalPairs = new OverlappingIntervalPairs();

    @DataProvider(name = NON_EXISTING_OVERLAP_ARRAY)
    public Object[][] nonOverlapArrayProvider() {
        return new Object[][]{
                {new int[][]{{12, 15},{3, 9},{10, 11},{17, 20}}},
                {new int[][]{{}}}
        };
    }

    @DataProvider(name = NORMAL_ARRAY)
    public Object[][] normalArrayProvider() {
        return new Object[][]{
                {new int[][]{{11, 15},{3, 9},{1, 4},{15, 18}, {13, 16}, {1, 2}}}
        };
    }

    @Test(dataProvider = NORMAL_ARRAY)
    public void getOverlappingIntervalPairs_normalArray_TheResultAsExpectedResult(int[][] availableNumbers) {
        int[][][] result  = overlappingIntervalPairs.getTheCoupleArrayOverlapRange(availableNumbers);
        int[][][] expectedResult = new int[][][]{{{11,15},{15,18}},{{11, 15},{13, 16}},{{3, 9},{1, 4}},{{1, 4}, {1, 2}},{{15, 18},{13, 16}}};
        Assert.assertTrue(Arrays.deepEquals(expectedResult, result));
    }

    @Test(dataProvider = NON_EXISTING_OVERLAP_ARRAY)
    public void getOverlappingIntervalPairs_nonOverlapArray(int[][] availableNumbers) {
        int[][][] result  = overlappingIntervalPairs.getTheCoupleArrayOverlapRange(availableNumbers);
        Assert.assertEquals( result.length, 0);
    }
}
