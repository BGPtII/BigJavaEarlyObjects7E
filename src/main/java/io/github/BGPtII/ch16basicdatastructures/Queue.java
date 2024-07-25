package io.github.BGPtII.ch16basicdatastructures;

import java.util.NoSuchElementException;

/**
 * Implementation of a queue using a sequence of nodes for storing elements
 */
public class Queue {

    private Node first;
    private Node last;

    /**
     * Constructs an empty queue
     */
    public Queue() {
        first = null;
        last = null;
    }

    /**
     * Adds a node containing the specified element to the back of the node link
     * @param element the data of the new node
     */
    public void add(Object element) {
        Node newNode = new Node();
        newNode.setData(element);
        if (first == null) {
            first = newNode;
        }
        else {
            last.setNext(newNode);
        }
        last = newNode;
    }

    /**
     * Removes a node from the front of the node link
     * @return the data of the removed node
     */
    public Object remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Object element = first.getData();
        first = first.getNext();
        return element;
    }

    /**
     * Moves the element at the head to the tail of the queue
     */
    public void firstToLast() {
        if (first == null || first.getNext() == null) {
            throw new NoSuchElementException();
        }
        Object element = first.getData();
        Node newNode = new Node();
        newNode.setData(element);
        first = first.getNext();
        last.setNext(newNode);
        last = newNode;
    }

    /**
     * Moves the element at the tail to the head of the queue
     */
    public void lastToFirst() {
        if (first == null || first.getNext() == null) {
            throw new NoSuchElementException();
        }
        Object element = remove();
        add(element);
    }

}
