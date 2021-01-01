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
        insertAtLast(show);
        return true;
    }

    @Override
    public void add(int index, TelevisionShow show) {
        checkPositionIndex(index);
        if (index == 0) {
            insertAtFirst(show);
        } else {
            Node currNode = head;
            Node newNode = new Node(show);
            for (int i = 0; i < index - 1; i++) {
                currNode = currNode.next;
            }
            newNode.next = currNode.next;
            currNode.next = newNode;
            size++;
        }
    }

    @Override
    public TelevisionShow get(int index) {
        checkElementIndex(index);
        Node currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        return currNode.show;
    }

    @Override
    public boolean contains(TelevisionShow show) {
        return indexOf(show) >= 0;
    }

    @Override
    public int indexOf(TelevisionShow show) {
        int index = 0;
        if (show == null) {
            for (Node n = head; n != null; n = n.next) {
                if (n.show == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node n = head; n != null; n = n.next) {
                if (show.equals(n.show)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(TelevisionShow show) {
        Node prevNode = null;
        if (show == null) {
            for (Node n = head; n != null; prevNode = n, n = n.next) {
                if (n.show == null) {
                    remove(prevNode, n);
                    return true;
                }
            }
        } else {
            for (Node n = head; n != null; prevNode = n, n = n.next) {
                if (show.equals(n.show)) {
                    remove(prevNode, n);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public TelevisionShow remove(int index) {
        checkElementIndex(index);
        TelevisionShow result = head.show;
        if (index == 0) {
            head = head.next;
        } else {
            Node currNode = head;
            for (int i = 0; i < index - 1; i++) {
                currNode = currNode.next;
            }
            result = currNode.next.show;
            remove(currNode, currNode.next);
        }
        return result;
    }

    private void insertAtFirst(TelevisionShow show) {
        Node newNode = new Node(show);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    private void insertAtLast(TelevisionShow show) {
        Node newNode = new Node(show);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while(last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
    }

    private void remove(Node prevNode, Node currNode) {
        if (prevNode == null) {
            head = currNode.next;
        } else {
            prevNode.next = currNode.next;
        }
        size--;
    }

    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
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