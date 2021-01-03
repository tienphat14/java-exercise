package collection;

/**
 * A collection of TV Show
 */
public interface TelevisionShowCollection {

    /**
     * Add a TV show to the TV collection.
     * @param show TV show to be added
     */
    void addShow(TelevisionShow show);

    /**
     * @return An iterator of TV show in this collection
     */
    TelevisionShowIterator iterator();

    /**
     * @param channel A channel which a TV show belongs to
     * @return An iterator of all TV show which belong to a specified channel in this collection
     */
    TelevisionShowIterator channelIterator(Channel channel);
}
