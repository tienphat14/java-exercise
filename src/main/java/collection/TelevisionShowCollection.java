package collection;

public interface TelevisionShowCollection {
    void addShow(TelevisionShow show);
    TelevisionShowIterator iterator();
    TelevisionShowIterator channelIterator(Channel channel);
}
