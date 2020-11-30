package languagebasic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class OverlappingIntervalPairsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayPackingTest.class);
    private OverlappingIntervalPairs overlappingIntervalPairs = new OverlappingIntervalPairs();

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
            {null, Collections.emptySet()},
            {Collections.emptyList(), Collections.emptySet()},
            {Collections.singletonList(new Interval(1, 5)), Collections.emptySet()},
            {Arrays.asList(new Interval(1, 5), new Interval(6, 10)), Collections.emptySet()},
            {Arrays.asList(new Interval(6, 10), new Interval(1, 5)), Collections.emptySet()},

            {Arrays.asList(new Interval(1, 5), new Interval(5, 10)),
                    Collections.singleton(new IntervalPair(new Interval(1, 5), new Interval(5, 10)))},
            {Arrays.asList(new Interval(1, 5), new Interval(4, 10)),
                    Collections.singleton(new IntervalPair(new Interval(1, 5), new Interval(4, 10)))},
            {Arrays.asList(new Interval(1, 5), new Interval(3, 5)),
                    Collections.singleton(new IntervalPair(new Interval(1, 5), new Interval(3, 5)))},
            {Arrays.asList(new Interval(1, 5), new Interval(2, 4)),
                    Collections.singleton(new IntervalPair(new Interval(1, 5), new Interval(2, 4)))},
            {Arrays.asList(new Interval(2, 5), new Interval(2, 4)),
                    Collections.singleton(new IntervalPair(new Interval(2, 5), new Interval(2, 4)))},
            {Arrays.asList(new Interval(3, 5), new Interval(2, 4)),
                    Collections.singleton(new IntervalPair(new Interval(3, 5), new Interval(2, 4)))},
            {Arrays.asList(new Interval(4, 5), new Interval(2, 4)),
                    Collections.singleton(new IntervalPair(new Interval(4, 5), new Interval(2, 4)))},

            {Arrays.asList(new Interval(1, 5), new Interval(1, 5)),
                    Collections.singleton(new IntervalPair(new Interval(1, 5), new Interval(1, 5)))},
            {Arrays.asList(new Interval(5, 5), new Interval(5, 10)),
                    Collections.singleton(new IntervalPair(new Interval(5, 5), new Interval(5, 10)))},
            {Arrays.asList(new Interval(1, 5), new Interval(5, 5)),
                    Collections.singleton(new IntervalPair(new Interval(1, 5), new Interval(5, 5)))},

            {Arrays.asList(
                    new Interval(1, 5),
                    new Interval(1, 5),
                    new Interval(1, 5)),
            Collections.singleton(new IntervalPair(new Interval(1, 5), new Interval(1, 5)))},

            {Arrays.asList(
                    new Interval(1, 5),
                    new Interval(2, 6),
                    new Interval(1, 5)),
            newHashSet(
                    new IntervalPair(new Interval(1, 5), new Interval(2, 6)),
                    new IntervalPair(new Interval(1, 5), new Interval(1, 5)))},

            {Arrays.asList(
                    new Interval(11, 15),
                    new Interval(3, 9),
                    new Interval(1, 4),
                    new Interval(15, 18)),
            newHashSet(
                    new IntervalPair(new Interval(11, 15), new Interval(15, 18)),
                    new IntervalPair(new Interval(3, 9), new Interval(1, 4)))},

            {Arrays.asList(
                    new Interval(1, 5),
                    new Interval(6, 8),
                    new Interval(5, 12),
                    new Interval(2, 6)),
            newHashSet(
                    new IntervalPair(new Interval(1, 5), new Interval(5, 12)),
                    new IntervalPair(new Interval(1, 5), new Interval(2, 6)),
                    new IntervalPair(new Interval(6, 8), new Interval(5, 12)),
                    new IntervalPair(new Interval(6, 8), new Interval(2, 6)),
                    new IntervalPair(new Interval(5, 12), new Interval(2, 6)))},

            {Arrays.asList(
                    new Interval(2, 4),
                    new Interval(3, 6),
                    new Interval(5, 7),
                    new Interval(1, 5),
                    new Interval(8, 10),
                    new Interval(4, 8)),
            newHashSet(
                    new IntervalPair(new Interval(2, 4), new Interval(3, 6)),
                    new IntervalPair(new Interval(2, 4), new Interval(1, 5)),
                    new IntervalPair(new Interval(2, 4), new Interval(4, 8)),
                    new IntervalPair(new Interval(3, 6), new Interval(5, 7)),
                    new IntervalPair(new Interval(3, 6), new Interval(1, 5)),
                    new IntervalPair(new Interval(3, 6), new Interval(4, 8)),
                    new IntervalPair(new Interval(5, 7), new Interval(1, 5)),
                    new IntervalPair(new Interval(5, 7), new Interval(4, 8)),
                    new IntervalPair(new Interval(1, 5), new Interval(4, 8)),
                    new IntervalPair(new Interval(8, 10), new Interval(4, 8)))}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void findOverlappingIntervalPairs(List<Interval> intervalList, Set<IntervalPair> result) {
        Assert.assertEquals(overlappingIntervalPairs.findOverlappingIntervalPairs(intervalList), result);
    }

    private Set<IntervalPair> newHashSet(IntervalPair... pairs) {
        Set<IntervalPair> set = new HashSet<>();
        Collections.addAll(set, pairs);
        return set;
    }
}