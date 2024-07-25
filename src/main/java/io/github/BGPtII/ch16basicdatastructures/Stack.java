package io.github.BGPtII.ch16basicdatastructures;

import java.util.NoSuchElementException;

/**
 * An implementation of a stack as an array
 */
public class Stack {

    private Object[] elements;
    private int currentSize = 0;

    /**
     * Constructs an empty stack
     */
    public Stack() {
        final int INITIAL_SIZE = 10;
        elements = new Object[INITIAL_SIZE];
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

    public boolean push(Object newElement) {
        growIfNecessary();
        currentSize++;

        elements[currentSize - 1] = newElement;
        return true;
    }

    /**
     * Removes the top element; shrinks the array by 50% when it is less than 25% full
     * @return the object at the last index
     */
    public Object pop() {
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

    /**
     * Checks whether the stack is empty
     * @return whether the stack is empty
     */
    public boolean empty() {
        return currentSize == 0;
    }

}
