package collection;

import java.util.LinkedList;
import java.util.List;

public class TelevisionShowCollectionImpl implements TelevisionShowCollection {
    TelevisionShowIteratorImpl iterator = new TelevisionShowIteratorImpl();

    @Override
    public TelevisionShowIterator iterator() {
        return iterator;
    }

    @Override
    public void addShow(TelevisionShow show) {
        if (show == null) {
            return;
        }
        iterator.add(show);
    }

    @Override
    public TelevisionShowIterator channelIterator(Channel channel) {
        TelevisionShowIteratorImpl tmp = new TelevisionShowIteratorImpl();
        while (iterator.hasNext()) {
            TelevisionShow tvShow = iterator.next();
            if (tvShow.getChannel().equals(channel)) {
                tmp.add(tvShow);
            }
        }
        return tmp;
    }

    private class TelevisionShowIteratorImpl implements TelevisionShowIterator {
        List<TelevisionShow> shows = new LinkedList<>();
        int currPosition = 0;

        @Override
        public boolean hasNext() {
            return ((currPosition + 1) < shows.size());
        }

        @Override
        public TelevisionShow next() {
            return shows.get(++currPosition);
        }

        @Override
        public boolean hasPrevious() {
            return ((currPosition - 1) < shows.size() && (currPosition - 1) >= 0);
        }

        @Override
        public TelevisionShow previous() {
            return shows.get(--currPosition);
        }

        public void add(TelevisionShow show) {
            shows.add(show);
        }
    }
}
