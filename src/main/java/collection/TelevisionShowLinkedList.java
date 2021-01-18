package collection;

/**
 * A simple single linked list of TV Show
 *
 *     HEAD
 *  ***********    ***********    ***********
 *  *   A  *  *--->*   B  *  *--->*   C  *  *---> NULL
 *  ***********    ***********    ***********
 *   data   next    data   next    data   next
 */
public interface TelevisionShowLinkedList {

    /**
     * @return the number of elements in this list
     */
    int size();

    /**
     * Appends the specified TV show to the end of this list.
     *
     * @param show TV show to be appended to this list
     * @return true if this list changed as a result of the call
     */
    boolean add(TelevisionShow show);

    /**
     * Inserts the specified TV show at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param show TV show to be inserted
     * @throws IndexOutOfBoundsException
     */
    void add(int index, TelevisionShow show);

    /**
     * Returns the TV show at the specified position in this list.
     *
     * @param index index of the TV show to return
     * @return the TV show at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    TelevisionShow get(int index);

    /**
     * Returns true if this list contains the specified TV show.
     *
     * @param show TV show whose presence in this list is to be tested
     * @return true if this list contains the specified TV show
     */
    boolean contains(TelevisionShow show);

    /**
     * Returns the index of the first occurrence of the specified TV show
     * in this list, or -1 if this list does not contain the TV show.
     *
     * @param show TV show to search for
     * @return the index of the first occurrence of the specified TV show in
     *         this list, or -1 if this list does not contain the TV show
     */
    int indexOf(TelevisionShow show);

    /**
     * Removes the first occurrence of the specified TV show from this list,
     * if it is present.  If this list does not contain the element, it is
     * unchanged.
     *
     * @param show TV show to be removed from this list, if present
     * @return true if this list contained the specified TV show
     */
    boolean remove(TelevisionShow show);

    /**
     * Removes the TV show at the specified position in this list.  Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the TV show that was removed from the list.
     *
     * @param index the index of the TV show to be removed
     * @return the TV show previously at the specified position
     * @throws IndexOutOfBoundsException
     */
    TelevisionShow remove(int index);
}
