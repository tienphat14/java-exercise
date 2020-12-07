package languagebasic;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OverlappingIntervalParisTest {
    @DataProvider(name = "abc")
    public Object[][] allArrayProvider() {
        return new Object[][]{
                {new int[][]{{1, 5}, {6, 8}, {5, 12}, {5, 12}, {2, 6}}, "[[1, 5] and [5, 12], [1, 5] and [2, 6], " +
                        "[6, 8] and [5, 12], [6, 8] and [2, 6], [5, 12] and [5, 12], [5, 12] and [2, 6]]"},
                {new int[][]{{1, 5}, {6, 8}, {5, 12}, {5, 12}, {2, 6}, {1, 5}}, "[[1, 5] and [5, 12], [1, 5] and [2, 6], " +
                        "[1, 5] and [1, 5], [6, 8] and [5, 12], [6, 8] and [2, 6], [5, 12] and [5, 12], [5, 12] " +
                        "and [2, 6]]"}
        };
    }

    @Test(dataProvider = "abc")
    public void testOverlappingIntervalParis(int[][] arrays, String expected) {
        String actual = OverlappingIntervalPairs.getOverlappingIntervalPairs(arrays).toString();
        Assert.assertEquals(actual, expected);
    }
}
