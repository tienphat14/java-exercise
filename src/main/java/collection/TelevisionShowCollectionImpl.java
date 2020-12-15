package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TelevisionShowCollectionImpl implements TelevisionShowCollection {

    private List<TelevisionShow> showList;

    public TelevisionShowCollectionImpl() {
        showList = new ArrayList<>();
    }

    @Override
    public TelevisionShowIterator iterator() {
        return new TelevisionShowIteratorImpl(showList);
    }

    @Override
    public void addShow(TelevisionShow show) {
        showList.add(show);
    }

    @Override
    public TelevisionShowIterator channelIterator(Channel channel) {
        return new TelevisionShowIteratorImpl(showList, channel);
    }

    private class TelevisionShowIteratorImpl implements TelevisionShowIterator {

        private List<TelevisionShow> showList;
        private Channel channel;
        private int position = - 1;

        private TelevisionShowIteratorImpl(List<TelevisionShow> showList) {
            this.showList = showList;
            this.channel = Channel.ALL;
        }

        private TelevisionShowIteratorImpl(List<TelevisionShow> showList, Channel channel) {
            this.showList = showList;
            this.channel = channel;
        }

        @Override
        public boolean hasNext() {
            if (position < -1) {
                position = -1;
            }
            while (position < showList.size() - 1) {
                TelevisionShow show = showList.get(position + 1);
                if (channel.equals(Channel.ALL) || show.getChannel().equals(channel)) {
                    return true;
                }
                position++;
            }
            return false;
        }

        @Override
        public TelevisionShow next() {
            if (hasNext()) {
                return showList.get(position++ + 1);
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            if (position > showList.size() - 1) {
                position = showList.size() - 1;
            }
            while (position > -1) {
                TelevisionShow show = showList.get(position);
                if (channel.equals(Channel.ALL) || show.getChannel().equals(channel)) {
                    return true;
                }
                position--;
            }
            return false;
        }

        @Override
        public TelevisionShow previous() {
            if (hasPrevious()) {
                return showList.get(position--);
            }
            throw new NoSuchElementException();
        }
    }
}
