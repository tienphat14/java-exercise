package languagebasic;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class IntervalPairTest {

    @Test
    public void testToString() {
        Assert.assertEquals(new IntervalPair(new Interval(1, 5), new Interval(2, 3)).toString(),
                "[1, 5] is overlap with [2, 3]");
    }

    @Test
    public void testEquals() {
        Assert.assertEquals(new IntervalPair(new Interval(1, 5), new Interval(2, 3)),
                new IntervalPair(new Interval(1, 5), new Interval(2, 3)));
        Assert.assertEquals(new IntervalPair(new Interval(1, 5), new Interval(2, 3)),
                new IntervalPair(new Interval(2, 3), new Interval(1, 5)));
    }

    @Test
    public void testEqualsWithHashSet() {
        Set<IntervalPair> intervalPairSet = new HashSet<>();
        intervalPairSet.add(new IntervalPair(new Interval(1, 5), new Interval(2, 3)));
        Assert.assertTrue(intervalPairSet.contains(new IntervalPair(new Interval(1, 5), new Interval(2, 3))));
        Assert.assertTrue(intervalPairSet.contains(new IntervalPair(new Interval(2, 3), new Interval(1, 5))));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(new IntervalPair(new Interval(1, 5), new Interval(2, 3)).hashCode(),
                new IntervalPair(new Interval(1, 5), new Interval(2, 3)).hashCode());
        Assert.assertEquals(new IntervalPair(new Interval(1, 5), new Interval(2, 3)).hashCode(),
                new IntervalPair(new Interval(2, 3), new Interval(1, 5)).hashCode());
    }
}