package io.github.BGPtII.ch16basicdatastructures;

import java.util.NoSuchElementException;

/**
 * Implements a Deque (double-ended queue as a circular array
 */
public class Deque {

    private Object[] elements;
    private int head;
    private int tail;
    private int currentSize;

    public Deque() {
        final int INITIAL_SIZE = 10;
        elements = new Object[INITIAL_SIZE];
        head = 0;
        tail = 0;
        currentSize = 0;
    }

    /**
     * Doubles the array and adds the previous elements from index 0 if there is no more room
     */
    private void growIfNecessary() {
        if (currentSize == elements.length) {
            Object[] newElements = new Object[2 * elements.length];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[(head + i) & elements.length];
            }
            elements = newElements;
            head = 0;
            tail = currentSize;
        }
    }

    /**
     * Adds an element to the head
     * @param newElement the element to add
     */
    public void addFirst(Object newElement) {
        growIfNecessary();
        head = (head - 1 + elements.length) % elements.length;
        elements[head] = newElement;
        currentSize++;
    }

    /**
     * Removes an element from the head
     * @return the removed element
     */
    public Object removeFirst() {
        if (currentSize == 0) {
            throw new NoSuchElementException();
        }
        Object removed = elements[head];
        head = (head + 1) % elements.length;
        currentSize--;
        return removed;
    }

    /**
     * Adds an element to the tail
     * @param newElement the element to add
     */
    public void addLast(Object newElement) {
        growIfNecessary();
        currentSize++;
        elements[tail] = newElement;
        tail = (tail + 1) % elements.length;
    }

    /**
     * Removes the element at the tail
     * @return the removed element
     */
    public Object removeLast() {
        if (currentSize == 0) {
            throw new NoSuchElementException();
        }
        Object removed = elements[tail];
        tail = (tail - 1 + elements.length) % elements.length;
        currentSize--;
        return removed;
    }

    /**
     * Gets the current size
     * @return the current amount of elements
     */
    public int size() {
        return currentSize;
    }

}
