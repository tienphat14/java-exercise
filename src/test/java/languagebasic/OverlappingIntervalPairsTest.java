package languagebasic;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OverlappingIntervalPairsTest {
    private OverlappingIntervalPairs pairs;

    @Before
    public void setUp() {
        pairs = new OverlappingIntervalPairs();
    }

    @Test
    public void testOverlap() {
        Assert.assertEquals("[1, 20] and [4, 21], [1, 20] and [5, 20], [1, 20] and [6, 18], [1, 20] and [1, 100]," +
                        " [4, 21] and [5, 20], [4, 21] and [6, 18], [4, 21] and [1, 100], [5, 20] and [6, 18], [5, 20] and [1, 100], [6, 18] and [1, 100]",
                pairs.findOverlap(new int[]{1, 20},
                        new int[]{4, 21},
                        new int[]{5, 20},
                        new int[]{6, 18},
                        new int[]{1, 100}));
    }

}