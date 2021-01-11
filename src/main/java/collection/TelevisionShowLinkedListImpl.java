package collection;

import java.util.ArrayList;
import java.util.List;

public class TelevisionShowLinkedListImpl implements TelevisionShowLinkedList {

    private int size;

    private List<TelevisionShow> tvShow;

    private Node head;

    public TelevisionShowLinkedListImpl(){
        tvShow = new ArrayList<>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(TelevisionShow show) {
        if(show == null){
            throw new NullPointerException("The input television show is null");
        }
        size++;
        return tvShow.add(show);
    }

    @Override
    public void add(int index, TelevisionShow show){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("The index out of range");
        if(show == null)
            throw new NullPointerException("The input television show is null");
        size++;
        tvShow.add(index, show);
    }

    @Override
    public TelevisionShow get(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("The index out of range");
        return tvShow.get(index);
    }

    @Override
    public boolean contains(TelevisionShow show) {
        return indexOf(show) >= 0;
    }

    @Override
    public int indexOf(TelevisionShow show) {
        if(show == null)
            throw new NullPointerException("The input television show is null");
        return tvShow.indexOf(show);
    }

    @Override
    public boolean remove(TelevisionShow show) {
        if(show == null)
            throw new NullPointerException("The input television show is null");
        size--;
        return tvShow.removeIf(s -> s.equals(show));
    }

    @Override
    public TelevisionShow remove(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("The index out of range");
        size--;
        return tvShow.remove(index);
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
