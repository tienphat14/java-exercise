package collection;

import java.util.NoSuchElementException;

/**
 * An iterator for the TV Show collection that allows
 * the programmer to traverse in either direction.
 *
 * Its cursor position always lies between the element
 * that would be returned by a call to previous() and
 * the element that would be returned by a call to next().
 *
 * An iterator for a collection of length n has n+1 possible
 * cursor positions, as illustrated by the carets (^) below:
 *                      Element(0)   Element(1)   Element(2)   ... Element(n-1)
 * cursor positions:  ^            ^            ^            ^                  ^
 */
public interface TelevisionShowIterator {

    /**
     * @return true if the iterator has more elements
     * when traversing in the forward direction
     */
    boolean hasNext();

    /**
     * Returns the next element and advances the cursor position.
     * This method may be called repeatedly to iterate through the collection,
     * or intermixed with calls to previous() to go back and forth.
     * (Note that alternating calls to next() and previous()
     * will return the same element repeatedly.)
     *
     * @return the next element in the collection
     * @throws NoSuchElementException if the iteration has no next element
     */
    TelevisionShow next();

    /**
     * @return true if the iterator has more elements
     * when traversing in the backward direction
     */
    boolean hasPrevious();

    /**
     * Returns the previous element and moves the cursor position backwards.
     * This method may be called repeatedly to iterate through the collection backwards,
     * or intermixed with calls to next() to go back and forth.
     * (Note that alternating calls to next() and previous()
     * will return the same element repeatedly.)
     *
     * @return the previous element in the collection
     * @throws NoSuchElementException if the iteration has no previous element
     */
    TelevisionShow previous();
}