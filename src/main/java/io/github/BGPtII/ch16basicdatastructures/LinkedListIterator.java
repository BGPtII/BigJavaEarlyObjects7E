package io.github.BGPtII.ch16basicdatastructures;

import java.util.NoSuchElementException;

public class LinkedListIterator implements ListIterator {

    private LinkedList linkedList;
    private Node position;
    private Node previous;
    private boolean isAfterNext;

    /**
     * Constructs an iterator that points to the front of the specified linked list
     * @param linkedList the linked list to iterate through
     */
    public LinkedListIterator(LinkedList linkedList) {
        this.linkedList = linkedList;
        position = null;
        previous = null;
        isAfterNext = false;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        previous = position; // Remember for remove
        isAfterNext = true;

        if (position == null) {
            position = linkedList.getFirstNode();
        }
        else {
            position = position.getNext();
        }

        return position.getData();
    }

    @Override
    public boolean hasNext() {
        if (position == null) {
            return linkedList.getFirstNode() != null;
        }
        else {
            return position.getNext() != null;
        }
    }

    @Override
    public void add(Object element) {
        if (position == null) {
            linkedList.addFirst(element);
        }
        else {
            position.setNext(new Node(element, position.getNext()));
            linkedList.incrementCurrentSize();
        }

        isAfterNext = false;
    }

    @Override
    public void remove() {
        if (!isAfterNext) {
            throw new IllegalStateException();
        }

        if (position == linkedList.getFirstNode()) {
            linkedList.removeFirst();
        }
        else {
            previous.setNext(position.getNext());
        }
        position = previous;
        isAfterNext = false;
        linkedList.decrementCurrentSize();
    }

    @Override
    public void set(Object element) {
        if (!isAfterNext) {
            throw new IllegalStateException();
        }
        position.setData(element);
    }

}
