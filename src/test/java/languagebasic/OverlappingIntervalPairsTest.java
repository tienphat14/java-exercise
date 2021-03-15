package languagebasic;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OverlappingIntervalPairsTest {
    private static final String OVERLAPPING_INTERVAL_PAIRS = "overlappingIntervalPairs";
    private OverlappingIntervalPairs overlappingIntervalPairs = new OverlappingIntervalPairs();

    @DataProvider(name = OVERLAPPING_INTERVAL_PAIRS)
    public Object[][] overlappingIntervalPairsProvider() {
        return new Object[][]{
                {new int[][]{{1, 5}, {5, 12}, {6, 8}, {5, 12}, {2, 6}, {5, 7}}}
        };
    }

    @Test(dataProvider = OVERLAPPING_INTERVAL_PAIRS)
    public void overlappingIntervalPairs_returnOverlappingPairs(int[][] givenIntegers) {
        overlappingIntervalPairs.overlappingIntervalPairs(givenIntegers);
    }
}