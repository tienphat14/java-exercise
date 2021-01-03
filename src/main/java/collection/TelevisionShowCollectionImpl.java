package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TelevisionShowCollectionImpl implements TelevisionShowCollection {

    private List<TelevisionShow> providedListShow;

    public TelevisionShowCollectionImpl() {
        providedListShow = new ArrayList<>();
    }

    @Override
    public TelevisionShowIterator iterator() {
        return new TelevisionShowIteratorImpl(this.providedListShow);
    }

    @Override
    public void addShow(TelevisionShow show) {
        providedListShow.add(show);
    }

    @Override
    public TelevisionShowIterator channelIterator(Channel channel) {
        if (channel == Channel.ALL) {
            return new TelevisionShowIteratorImpl(this.providedListShow);
        }
        return new TelevisionShowIteratorImpl(providedListShow.stream()
                                                              .filter(show -> show.getChannel() == channel)
                                                              .collect(Collectors.toList()));
    }

    private class TelevisionShowIteratorImpl implements TelevisionShowIterator {

        private int currentShowIndex = 0;
        private List<TelevisionShow> listShow;

        public TelevisionShowIteratorImpl(List<TelevisionShow> shows) {
            listShow = shows;
        }

        @Override
        public boolean hasNext() {
            return currentShowIndex < (listShow.size());
        }

        @Override
        public TelevisionShow next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            TelevisionShow currentShow = listShow.get(currentShowIndex);
            currentShowIndex += 1;
            return currentShow;
        }

        @Override
        public boolean hasPrevious() {
            return currentShowIndex > 0;
        }

        @Override
        public TelevisionShow previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            currentShowIndex -= 1;
            return listShow.get(currentShowIndex);
        }
    }
}
