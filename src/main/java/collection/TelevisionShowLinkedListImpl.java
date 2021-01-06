package collection;

public class TelevisionShowLinkedListImpl implements TelevisionShowLinkedList {

    private int size;

    private Node head;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(TelevisionShow show) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, TelevisionShow show) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public TelevisionShow get(int index) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(TelevisionShow show) {
        return indexOf(show) >= 0;
    }

    @Override
    public int indexOf(TelevisionShow show) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(TelevisionShow show) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public TelevisionShow remove(int index) {
        // TODO
        throw new UnsupportedOperationException();
    }

    private class Node {
        TelevisionShow show;
        Node next;

        Node(TelevisionShow show) {
            this.show = show;
            next = null;
        }
    }
}
