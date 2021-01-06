package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TelevisionShowCollectionImpl implements TelevisionShowCollection {

    private List<TelevisionShow> tvListShow;

    public TelevisionShowCollectionImpl() {
        tvListShow = new ArrayList<>();
    }

    @Override
    public TelevisionShowIterator iterator() {
        return new TelevisionShowIteratorImpl(this.tvListShow);
    }

    @Override
    public void addShow(TelevisionShow show) {
        tvListShow.add(show);
    }

    @Override
    public TelevisionShowIterator channelIterator(Channel channel) {
        if (channel == Channel.ALL) return new TelevisionShowIteratorImpl(this.tvListShow);
        return new TelevisionShowIteratorImpl(tvListShow.stream().filter(show -> show.getChannel() == channel).collect(Collectors.toList()));
    }

    private class TelevisionShowIteratorImpl implements TelevisionShowIterator {

        private int currChannel = 0;
        private List<TelevisionShow> tvShows;

        public TelevisionShowIteratorImpl(List<TelevisionShow> shows) {
            tvShows = shows;
        }

        @Override
        public boolean hasNext() {
            return currChannel < (tvShows.size());
        }

        @Override
        public TelevisionShow next() {
            if (!hasNext()) throw new NoSuchElementException();
            return tvShows.get(currChannel++);
        }

        @Override
        public boolean hasPrevious() {
            return currChannel > 0;
        }

        @Override
        public TelevisionShow previous() {
            if (!hasPrevious())  throw new NoSuchElementException();
            return tvShows.get(--currChannel);
        }
    }
}
