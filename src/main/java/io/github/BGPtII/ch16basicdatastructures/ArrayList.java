package io.github.BGPtII.ch16basicdatastructures;

import java.util.NoSuchElementException;

/**
 * Implements an array list
 */
public class ArrayList {

    private Object[] elements;
    private int currentSize;

    public ArrayList() {
        final int INITIAL_SIZE = 10;
        elements = new Object[INITIAL_SIZE];
        currentSize = 0;
    }

    public int size() {
        return currentSize;
    }

    private void checkBounds(int n) {
        if (n < 0 || n >= currentSize) {
            throw new IndexOutOfBoundsException();
        }
    }

    public Object get(int pos) {
        checkBounds(pos);
        return elements[pos];
    }

    public void set(int pos, Object element) {
        checkBounds(pos);
        elements[pos] = element;
    }

    public Object remove(int pos) {
        checkBounds(pos);

        Object removed = elements[pos];

        for (int i = pos + 1; i < currentSize; i++) {
            elements[i - 1] = elements[i];
        }

        currentSize--;
        return removed;
    }

    private void growIfNecessary() {
        if (currentSize == elements.length) {
            Object[] newElements = new Object[2 * elements.length];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    public boolean addLast(Object newElement) {
        growIfNecessary();
        currentSize++;

        elements[currentSize - 1] = newElement;
        return true;
    }

    /**
     * Removes the last element; shrinks the array by 50% when it is less than 25% full
     * @return the object at the last index
     */
    public Object removeLast() {
        if (currentSize == 0) {
            throw new NoSuchElementException();
        }
        Object element = elements[--currentSize];
        if ((double) currentSize / elements.length < 0.25) {
            Object[] newElements = new Object[elements.length / 2];
            for (int i = 0; i < currentSize; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        return element;
    }

}
