package languagebasic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class OverlappingIntervalPairsTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(OverlappingIntervalPairsTest.class);
    private static final String NORMAL_ARRAY = "normalArray";
    private static final String NORMAL_ARRAY_2 = "normalArray2";
    private OverlappingIntervalPairs overlappingIntervalPairs = new OverlappingIntervalPairs();


    @DataProvider(name = NORMAL_ARRAY)
    public Object[][] normalArrayProvider() {
        return new Object[][]{
                {new int[][]{{11, 15}, {3, 9}, {1, 4}, {15, 18}}}
        };
    }

    @DataProvider(name = NORMAL_ARRAY_2)
    public Object[][] normalArrayProvider2() {
        return new Object[][]{
                {new int[][]{{11, 20}, {21, 25}, {9, 15}, {14, 21}}}
        };
    }

    @Test(dataProvider = NORMAL_ARRAY)
    public void getArrayLists_normalArray_returnAllOverlappingIntervalPairs(int[][] array){
        String result = overlappingIntervalPairs.getResultOverlappingArray(array);
        //Given [11, 15], [3, 9], [1, 4], [15, 18] => return [11, 15] and [15, 18], [3, 9] and [1, 4].
        Assert.assertEquals(result, "[[11, 15] and [15, 18], [3, 9] and [1, 4]]" );
    }

    @Test(dataProvider = NORMAL_ARRAY_2)
    public void getArrayLists_normalArray2_returnAllOverlappingIntervalPairs(int[][] array){
        String result = overlappingIntervalPairs.getResultOverlappingArray(array);
        //Given [11, 15], [3, 9], [1, 4], [15, 18] => return [11, 15] and [15, 18], [3, 9] and [1, 4].
        Assert.assertEquals(result, "[[11, 20] and [9, 15], [11, 20] and [14, 21], [21, 25] and [14, 21], [9, 15] and [14, 21]]" );
    }
}