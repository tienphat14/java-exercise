package languagebasic;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class IntervalTest {

    @Test
    public void testToString() {
        Assert.assertEquals(new Interval(1, 2).toString(), "[1, 2]");
    }

    @Test
    public void testEquals() {
        Assert.assertEquals(new Interval(1, 2), new Interval(1, 2));
        Assert.assertNotEquals(new Interval(1, 2), new Interval(2, 1));
    }

    @Test
    public void testEqualsWithHashSet() {
        Set<Interval> intervalSet = new HashSet<>();
        intervalSet.add(new Interval(1, 2));
        Assert.assertTrue(intervalSet.contains(new Interval(1, 2)));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(new Interval(1, 2).hashCode(), new Interval(1, 2).hashCode());
        Assert.assertNotEquals(new Interval(1, 2).hashCode(), new Interval(2, 1).hashCode());
    }
}