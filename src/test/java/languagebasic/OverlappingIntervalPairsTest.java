package languagebasic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingIntervalPairsTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RandomRosterGeneratorTest.class);
    private final ArrayList<ArrayList<Integer>> emptyArray = new ArrayList<>();
    private final ArrayList<ArrayList<Integer>> oneOverlapping = new ArrayList<ArrayList<Integer>>() {{
        add(
                new ArrayList(){{add(11); add(15);}}
        );
        add(
                new ArrayList(){{add(19); add(21);}}
        );
        add(
                new ArrayList(){{add(15); add(18);}}
        );
    }};
    private static final ArrayList<ArrayList<Integer>> manyPairs = new ArrayList<ArrayList<Integer>>() {{
        add(
                new ArrayList(){{add(11); add(15);}}
        );
        add(
                new ArrayList(){{add(3); add(9);}}
        );
        add(
                new ArrayList(){{add(1); add(4);}}
        );
        add(
                new ArrayList(){{add(15); add(18);}}
        );
    }};
    private static final ArrayList<ArrayList<Integer>> morePairs = new ArrayList<ArrayList<Integer>>() {{
        add(
                new ArrayList(){{add(1); add(5);}}
        );
        add(
                new ArrayList(){{add(6); add(8);}}
        );
        add(
                new ArrayList(){{add(5); add(12);}}
        );
        add(
                new ArrayList(){{add(2); add(6);}}
        );
    }};
    private OverlappingIntervalPairs pairs = new OverlappingIntervalPairs();

    @Test
    public void givenEmptyArray_whenCheckOverlapping_thenReturnEmptyArr() {
        Assert.assertEquals(pairs.naiveMethod(emptyArray), emptyArray);
    }

    @Test
    public void givenSingleElementArr_whenCheckOverlapping_thenReturnEmptyArr() {
        Assert.assertEquals(pairs.naiveMethod(emptyArray), emptyArray);
    }

    @Test
    public void givenOneOverlappingArrPair_whenCheckOverlapping_thenReturnAPair() {
        List<List<List<Integer>>> expected = Arrays.asList(
                Arrays.asList(Arrays.asList(11, 15), Arrays.asList(15, 18))
        );
        Assert.assertEquals(pairs.naiveMethod(this.oneOverlapping), expected);
    }

    @Test
    public void givenManyOverlappingArrPairs_whenCheckOverlapping_thenReturnPairs() {
        List<List<List<Integer>>> expected = Arrays.asList(
                Arrays.asList(
                        Arrays.asList(11, 15),
                        Arrays.asList(15, 18)
                ),
                Arrays.asList(
                        Arrays.asList(3, 9),
                        Arrays.asList(1, 4)
                )
        );
        Assert.assertEquals(pairs.naiveMethod(manyPairs), expected);
    }

    @Test
    public void givenMoreOverlappingArrPairs_whenCheckOverlapping_thenReturnPairs() {
        List<List<List<Integer>>> expected = Arrays.asList(
                Arrays.asList(
                        Arrays.asList(1, 5),
                        Arrays.asList(5, 12)
                ),
                Arrays.asList(
                        Arrays.asList(1, 5),
                        Arrays.asList(2, 6)
                ),
                Arrays.asList(
                        Arrays.asList(6, 8),
                        Arrays.asList(5, 12)
                ),
                Arrays.asList(
                        Arrays.asList(6, 8),
                        Arrays.asList(2, 6)
                ),
                Arrays.asList(
                        Arrays.asList(5, 12),
                        Arrays.asList(2, 6)
                )
        );
        Assert.assertEquals(pairs.naiveMethod(morePairs), expected);
    }
}
