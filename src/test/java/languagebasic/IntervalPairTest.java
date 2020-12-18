package languagebasic;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class IntervalPairTest {
    @Test
    public void testToString() {
        Assert.assertEquals(new IntervalPair.Interval(1, 2).toString(), "[1, 2]");
    }

    @Test
    public void testEquals() {
        Assert.assertEquals(new IntervalPair.Interval(1, 2), new IntervalPair.Interval(1, 2));
        Assert.assertNotEquals(new IntervalPair.Interval(1, 2), new IntervalPair.Interval(2, 1));
    }

    @Test
    public void testEqualsWithHashSet() {
        Set<IntervalPair.Interval> intervalSet = new HashSet<>();
        intervalSet.add(new IntervalPair.Interval(1, 2));
        Assert.assertTrue(intervalSet.contains(new IntervalPair.Interval(1, 2)));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(new IntervalPair.Interval(1, 2).hashCode(), new IntervalPair.Interval(1, 2).hashCode());
        Assert.assertNotEquals(new IntervalPair.Interval(1, 2).hashCode(), new IntervalPair.Interval(2, 1).hashCode());
    }

    @Test
    public void testToStringPair() {
        Assert.assertEquals(new IntervalPair(new IntervalPair.Interval(1, 5), new IntervalPair.Interval(2, 3)).toString(),
                "[1, 5] is overlap with [2, 3]");
    }
    @Test
    public void testEqualsPair() {
        Assert.assertEquals(new IntervalPair(new IntervalPair.Interval(1, 5), new IntervalPair.Interval(2, 3)),
                new IntervalPair(new IntervalPair.Interval(1, 5), new IntervalPair.Interval(2, 3)));
        Assert.assertEquals(new IntervalPair(new IntervalPair.Interval(1, 5), new IntervalPair.Interval(2, 3)),
                new IntervalPair(new IntervalPair.Interval(2, 3), new IntervalPair.Interval(1, 5)));
    }

    @Test
    public void testEqualsWithHashSetPair() {
        Set<IntervalPair> intervalPairSet = new HashSet<>();
        intervalPairSet.add(new IntervalPair(new IntervalPair.Interval(1, 5), new IntervalPair.Interval(2, 3)));
        Assert.assertTrue(intervalPairSet.contains(new IntervalPair(new IntervalPair.Interval(1, 5), new IntervalPair.Interval(2, 3))));
        Assert.assertTrue(intervalPairSet.contains(new IntervalPair(new IntervalPair.Interval(2, 3), new IntervalPair.Interval(1, 5))));
    }

    @Test
    public void testHashCodePair() {
        Assert.assertEquals(new IntervalPair(new IntervalPair.Interval(1, 5), new IntervalPair.Interval(2, 3)).hashCode(),
                new IntervalPair(new IntervalPair.Interval(1, 5), new IntervalPair.Interval(2, 3)).hashCode());
        Assert.assertEquals(new IntervalPair(new IntervalPair.Interval(1, 5), new IntervalPair.Interval(2, 3)).hashCode(),
                new IntervalPair(new IntervalPair.Interval(2, 3), new IntervalPair.Interval(1, 5)).hashCode());
    }
}
