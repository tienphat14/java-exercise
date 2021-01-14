package collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class TelevisionShowCollectionTest {

    private TelevisionShowCollection tvShowCollection;

    @Before
    public void setup() {
        tvShowCollection = new TelevisionShowCollectionImpl();
    }

    @Test
    public void addShow_shouldSuccess() {
        tvShowCollection.addShow(new TelevisionShow(10.0, Channel.VTV3, "Test show"));
    }

    @Test
    public void iterator_noNextElement_shouldReturnFalse_whenCheckForNext() {
        tvShowCollection.addShow(new TelevisionShow(10.0, Channel.VTV3, "Test show"));
        TelevisionShowIterator iterator = tvShowCollection.iterator();
        iterator.next();

        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_noNextElement_shouldThrowException_whenTryToGetNext() {
        tvShowCollection.addShow(new TelevisionShow(10.0, Channel.VTV3, "Test show"));
        TelevisionShowIterator iterator = tvShowCollection.iterator();
        iterator.next();
        iterator.next();
    }

    @Test
    public void iterator_noPreviousElement_shouldReturnFalse_whenCheckForPrevious() {
        tvShowCollection.addShow(new TelevisionShow(10.0, Channel.VTV3, "Test show"));
        TelevisionShowIterator iterator = tvShowCollection.iterator();

        Assert.assertFalse(iterator.hasPrevious());
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_noPreviousElement_shouldThrowException_whenTryToGetPrevious() {
        tvShowCollection.addShow(new TelevisionShow(10.0, Channel.VTV3, "Test show"));
        TelevisionShowIterator iterator = tvShowCollection.iterator();
        iterator.previous();
    }

    @Test
    public void iterator_travelInBothDirections_shouldReturnSameElement() {
        tvShowCollection.addShow(new TelevisionShow(10.0, Channel.VTV3, "Test show"));
        TelevisionShowIterator iterator = tvShowCollection.iterator();

        Assert.assertTrue(iterator.hasNext());
        Assert.assertFalse(iterator.hasPrevious());

        TelevisionShow nextShow = iterator.next();

        Assert.assertFalse(iterator.hasNext());
        Assert.assertTrue(iterator.hasPrevious());

        TelevisionShow previousShow = iterator.previous();

        Assert.assertTrue(iterator.hasNext());
        Assert.assertFalse(iterator.hasPrevious());
        Assert.assertEquals(nextShow, previousShow);
    }

    @Test
    public void channelIterator_noNextElement_shouldReturnFalse_whenCheckForNext() {
        tvShowCollection.addShow(new TelevisionShow(10.0, Channel.VTV1, "Test show"));
        tvShowCollection.addShow(new TelevisionShow(11.0, Channel.VTV3, "Test show2"));
        tvShowCollection.addShow(new TelevisionShow(12.0, Channel.VTV1, "Test show3"));
        TelevisionShowIterator channelIterator = tvShowCollection.channelIterator(Channel.VTV3);
        channelIterator.next();

        Assert.assertFalse(channelIterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void channelIterator_noNextElement_shouldThrowException_whenTryToGetNext() {
        tvShowCollection.addShow(new TelevisionShow(10.0, Channel.VTV1, "Test show"));
        tvShowCollection.addShow(new TelevisionShow(11.0, Channel.VTV3, "Test show2"));
        tvShowCollection.addShow(new TelevisionShow(12.0, Channel.VTV1, "Test show3"));
        TelevisionShowIterator channelIterator = tvShowCollection.channelIterator(Channel.VTV3);
        channelIterator.next();
        channelIterator.next();
    }

    @Test
    public void channelIterator_noPreviousElement_shouldReturnFalse_whenCheckForPrevious() {
        tvShowCollection.addShow(new TelevisionShow(10.0, Channel.VTV1, "Test show"));
        tvShowCollection.addShow(new TelevisionShow(11.0, Channel.VTV3, "Test show2"));
        tvShowCollection.addShow(new TelevisionShow(12.0, Channel.VTV1, "Test show3"));
        TelevisionShowIterator channelIterator = tvShowCollection.channelIterator(Channel.VTV3);

        Assert.assertFalse(channelIterator.hasPrevious());
    }

    @Test(expected = NoSuchElementException.class)
    public void channelIterator_noPreviousElement_shouldThrowException_whenTryToGetPrevious() {
        tvShowCollection.addShow(new TelevisionShow(10.0, Channel.VTV1, "Test show"));
        tvShowCollection.addShow(new TelevisionShow(11.0, Channel.VTV3, "Test show2"));
        tvShowCollection.addShow(new TelevisionShow(12.0, Channel.VTV1, "Test show3"));
        TelevisionShowIterator channelIterator = tvShowCollection.channelIterator(Channel.VTV3);
        channelIterator.previous();
    }

    @Test
    public void channelIterator_travelInBothDirections_shouldReturnSameElement() {
        tvShowCollection.addShow(new TelevisionShow(10.0, Channel.VTV1, "Test show"));
        tvShowCollection.addShow(new TelevisionShow(11.0, Channel.VTV3, "Test show2"));
        tvShowCollection.addShow(new TelevisionShow(12.0, Channel.VTV1, "Test show3"));
        TelevisionShowIterator channelIterator = tvShowCollection.channelIterator(Channel.VTV3);

        Assert.assertTrue(channelIterator.hasNext());
        Assert.assertFalse(channelIterator.hasPrevious());

        TelevisionShow nextShow = channelIterator.next();

        Assert.assertFalse(channelIterator.hasNext());
        Assert.assertTrue(channelIterator.hasPrevious());

        TelevisionShow previousShow = channelIterator.previous();

        Assert.assertTrue(channelIterator.hasNext());
        Assert.assertFalse(channelIterator.hasPrevious());
        Assert.assertEquals(nextShow, previousShow);
    }
}