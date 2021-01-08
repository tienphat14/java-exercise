package collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TelevisionShowLinkedListTest {

    private TelevisionShowLinkedList televisionShowLinkedList;

    @Before
    public void setup() {
        televisionShowLinkedList = new TelevisionShowLinkedListImpl();
    }

    @Test
    public void whenInitialized_sizeShouldBeZero() {
        Assert.assertEquals(0, televisionShowLinkedList.size());
    }

    @Test
    public void addSuccess_sizeShouldIncrease() {
        televisionShowLinkedList.add(new TelevisionShow(10.0, Channel.VTV3, "test1"));
        televisionShowLinkedList.add(new TelevisionShow(11.0, Channel.VTV3, "test2"));
        televisionShowLinkedList.add(new TelevisionShow(12.0, Channel.VTV3, "test3"));

        Assert.assertEquals(3, televisionShowLinkedList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtInvalidIndex_shouldThrowIndexOutOfBoundsException() {
        televisionShowLinkedList.add(-1, new TelevisionShow(10.0, Channel.VTV3, "test1"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getAtInvalidIndex_shouldThrowIndexOutOfBoundsException() {
        televisionShowLinkedList.get(-1);
    }

    @Test
    public void addAtValidIndex_shouldShiftTheCurrentAndSubsequentElementToTheRight() {
        televisionShowLinkedList.add(new TelevisionShow(10.0, Channel.VTV3, "test1"));
        televisionShowLinkedList.add(new TelevisionShow(11.0, Channel.VTV3, "test2"));
        televisionShowLinkedList.add(new TelevisionShow(12.0, Channel.VTV3, "test3"));
        televisionShowLinkedList.add(2, new TelevisionShow(13.0, Channel.VTV3, "test4"));

        Assert.assertEquals(4, televisionShowLinkedList.size());
        Assert.assertEquals("test1", televisionShowLinkedList.get(0).getName());
        Assert.assertEquals("test2", televisionShowLinkedList.get(1).getName());
        Assert.assertEquals("test4", televisionShowLinkedList.get(2).getName());
        Assert.assertEquals("test3", televisionShowLinkedList.get(3).getName());
    }

    @Test
    public void theShowNotInTheList_contains_shouldReturnFalse() {
        televisionShowLinkedList.add(new TelevisionShow(10.0, Channel.VTV3, "test1"));
        Assert.assertFalse(televisionShowLinkedList.contains(new TelevisionShow(10.0, Channel.VTV3, "test1")));
    }

    @Test
    public void theShowInTheList_contains_shouldReturnTrue() {
        TelevisionShow show = new TelevisionShow(10.0, Channel.VTV3, "test1");
        televisionShowLinkedList.add(show);
        Assert.assertTrue(televisionShowLinkedList.contains(show));
    }

    @Test
    public void theShowNotInTheList_indexOf_shouldReturnNegative() {
        televisionShowLinkedList.add(new TelevisionShow(10.0, Channel.VTV3, "test1"));
        Assert.assertEquals(-1, televisionShowLinkedList.indexOf(new TelevisionShow(10.0, Channel.VTV3, "test1")));
    }

    @Test
    public void theShowInTheList_indexOf_shouldReturnPositive() {
        TelevisionShow show1 = new TelevisionShow(10.0, Channel.VTV3, "test1");
        TelevisionShow show2 = new TelevisionShow(11.0, Channel.VTV3, "test2");
        TelevisionShow show3 = new TelevisionShow(12.0, Channel.VTV3, "test3");
        televisionShowLinkedList.add(show1);
        televisionShowLinkedList.add(show2);
        televisionShowLinkedList.add(show3);

        Assert.assertEquals(0, televisionShowLinkedList.indexOf(show1));
        Assert.assertEquals(1, televisionShowLinkedList.indexOf(show2));
        Assert.assertEquals(2, televisionShowLinkedList.indexOf(show3));
    }

    @Test
    public void theShowNotInTheList_remove_shouldReturnFalse() {
        televisionShowLinkedList.add(new TelevisionShow(10.0, Channel.VTV3, "test1"));
        Assert.assertFalse(televisionShowLinkedList.remove(new TelevisionShow(10.0, Channel.VTV3, "test1")));
    }

    @Test
    public void theShowInTheList_remove_shouldReturnTrue() {
        TelevisionShow show = new TelevisionShow(10.0, Channel.VTV3, "test1");
        televisionShowLinkedList.add(show);
        Assert.assertTrue(televisionShowLinkedList.remove(show));
    }

    @Test
    public void theShowInTheList_remove_shouldDecreaseTheSize() {
        TelevisionShow show1 = new TelevisionShow(10.0, Channel.VTV3, "test1");
        TelevisionShow show2 = new TelevisionShow(11.0, Channel.VTV3, "test2");
        TelevisionShow show3 = new TelevisionShow(12.0, Channel.VTV3, "test3");
        televisionShowLinkedList.add(show1);
        televisionShowLinkedList.add(show2);
        televisionShowLinkedList.add(show3);
        televisionShowLinkedList.remove(show2);

        Assert.assertEquals(2, televisionShowLinkedList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeAtInvalidIndex_shouldThrowIndexOutOfBoundsException() {
        televisionShowLinkedList.remove(-1);
    }

    @Test
    public void removeAtValidIndex_shouldShiftTheSubsequentElementsToTheLeft() {
        TelevisionShow show1 = new TelevisionShow(10.0, Channel.VTV3, "test1");
        TelevisionShow show2 = new TelevisionShow(11.0, Channel.VTV3, "test2");
        TelevisionShow show3 = new TelevisionShow(12.0, Channel.VTV3, "test3");
        TelevisionShow show4 = new TelevisionShow(13.0, Channel.VTV3, "test4");
        TelevisionShow show5 = new TelevisionShow(14.0, Channel.VTV3, "test5");
        televisionShowLinkedList.add(show1);
        televisionShowLinkedList.add(show2);
        televisionShowLinkedList.add(show3);
        televisionShowLinkedList.add(show4);
        televisionShowLinkedList.add(show5);

        Assert.assertEquals("test4", televisionShowLinkedList.remove(3).getName());
        Assert.assertEquals("test2", televisionShowLinkedList.remove(1).getName());
        Assert.assertEquals(3, televisionShowLinkedList.size());
        Assert.assertEquals("test1", televisionShowLinkedList.get(0).getName());
        Assert.assertEquals("test3", televisionShowLinkedList.get(1).getName());
        Assert.assertEquals("test5", televisionShowLinkedList.get(2).getName());
    }
}