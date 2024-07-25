package io.github.BGPtII.ch16basicdatastructures;

import java.util.NoSuchElementException;

/**
 * Implements a single-linked linked list using chained nodes
 */
public class LinkedList {

    private Node first;
    private int currentSize;

    /**
     * Create an empty linked list
     */
    public LinkedList() {
        first = null;
        currentSize = 0;
    }

    public Node getFirstNode() {
        return first;
    }

    public void incrementCurrentSize() {
        currentSize++;
    }

    public void decrementCurrentSize() {
        currentSize--;
    }

    /**
     * Returns the first element in the linked list
     * @return the first element in the linked list
     */
    public Object getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.getData();
    }

    /**
     * Removes the first element in the linked list
     * @return the removed element
     */
    public Object removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Object element = first.getData();
        first = first.getNext();
        currentSize--;
        return element;
    }

    /**
     * Adds an element to the front of the linked list
     * @param element the element to add
     */
    public void addFirst(Object element) {
        first = new Node(element, first);
        currentSize++;
    }

    /**
     * Reverses the links through rerouting
     */
    public void reverse() {
        Node previous = null;
        Node current = first;
        Node next;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        first = previous;
    }

    /**
     * Gets the current size of the linked list
     * @return the number of elements
     */
    public int size() {
        return currentSize;
    }

    /**
     * Returns an iterator for iterating through this list
     * @return the iterator
     */
    public ListIterator listIterator() {
        return new LinkedListIterator(this);
    }

}
