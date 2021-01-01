package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
        return new TelevisionShowIteratorImpl(
                showList.stream()
                        .filter(show -> channel.equals(show.getChannel()))
                        .collect(Collectors.toList()));
    }

    private class TelevisionShowIteratorImpl implements TelevisionShowIterator {

        private List<TelevisionShow> showList;
        private int position;

        private TelevisionShowIteratorImpl(List<TelevisionShow> showList) {
            this.showList = showList;
        }

        @Override
        public boolean hasNext() {
            return position < showList.size();
        }

        @Override
        public TelevisionShow next() {
            if (hasNext()) {
                return showList.get(position++);
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return position > 0;
        }

        @Override
        public TelevisionShow previous() {
            if (hasPrevious()) {
                return showList.get(--position);
            }
            throw new NoSuchElementException();
        }
    }
}
