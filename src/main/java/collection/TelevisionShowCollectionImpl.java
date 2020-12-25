package collection;

import java.util.*;

public class TelevisionShowCollectionImpl implements TelevisionShowCollection {
    TelevisionShowIteratorImpl televisionShowIteratorImpl = new TelevisionShowIteratorImpl();

    @Override
    public TelevisionShowIterator iterator() {
        return returnFirstPointer(televisionShowIteratorImpl);
    }

    @Override
    public void addShow(TelevisionShow show) {
        televisionShowIteratorImpl.add(show);
    }

    @Override
    public TelevisionShowIterator channelIterator(Channel channel) {
        if (channel.name() == "ALL") {
            return this.televisionShowIteratorImpl;
        }
        TelevisionShowIteratorImpl televisionShowIteratorImpl = new TelevisionShowIteratorImpl();
        returnFirstPointer(this.televisionShowIteratorImpl);
        while (this.televisionShowIteratorImpl.hasNext()) {
            TelevisionShow televisionShow;
            televisionShow = this.televisionShowIteratorImpl.next();
            if (televisionShow.getChannel().name() == channel.name()) {
                televisionShowIteratorImpl.add(televisionShow);
            }
        }
        returnFirstPointer(this.televisionShowIteratorImpl);
        return returnFirstPointer(televisionShowIteratorImpl);
    }

    private class TelevisionShowIteratorImpl implements TelevisionShowIterator {
        public List<TelevisionShow> televisionShowList = new ArrayList<>();
        public ListIterator<TelevisionShow> televisionShowListIterator = televisionShowList.listIterator();

        @Override
        public boolean hasNext() {
            return televisionShowListIterator.hasNext();
        }

        @Override
        public TelevisionShow next() {
            return televisionShowListIterator.next();
        }

        @Override
        public boolean hasPrevious() {
            return televisionShowListIterator.hasPrevious();
        }

        @Override
        public TelevisionShow previous() {
            return televisionShowListIterator.previous();
        }

        public void add(TelevisionShow televisionShow) {
            televisionShowListIterator.add(televisionShow);
        }
    }

    public TelevisionShowIteratorImpl returnFirstPointer(TelevisionShowIteratorImpl televisionShowIteratorImpl) {
        while (televisionShowIteratorImpl.hasPrevious()) {
            televisionShowIteratorImpl.previous();
        }
        return televisionShowIteratorImpl;
    }
}