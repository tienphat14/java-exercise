package collection;

import java.util.ListIterator;

public interface TelevisionShowIterator {
    boolean hasNext();
    TelevisionShow next();
    boolean hasPrevious();
    TelevisionShow previous();
}
