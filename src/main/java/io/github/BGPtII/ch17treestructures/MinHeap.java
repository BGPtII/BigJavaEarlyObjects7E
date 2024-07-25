package io.github.BGPtII.ch17treestructures;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> {

    private ArrayList<T> elements;

    /**
     * Constructs an empty heap
     */
    public MinHeap() {
        elements = new ArrayList<>();
        elements.add(null);
    }

    /**
     * Adds a new element
     * @param newElement the element to add
     */
    public void add(T newElement) {
        // Adds a new leaf
        elements.add(null);
        int index = elements.size() - 1;

        // Demote parents that are larger than the new element
        while (index > 1 && elements.get(index / 2).compareTo(newElement) > 0) {
            elements.set(index, elements.get(index / 2));
            index = index / 2;
        }

        // Store the new element in the vacant slot
        elements.set(index, newElement);
    }

    /**
     * Gets the minimum element stored
     * @return the minimum element
     */
    public T peek() {
        return elements.get(1);
    }

    /**
     * Removes the minimum element stored
     * @return the minimum element
     */
    public T remove() {
        T minimum = elements.get(1);

        // Remove last element
        int lastIndex = elements.size() - 1;
        T last = elements.remove(lastIndex);

        if (lastIndex > 1) {
            elements.set(1, last);
            fixHeap();
        }

        return minimum;
    }

    /**
     * Checks whether the min heap is empty
     * @return whether the min heap is empty
     */
    public boolean empty() {
        return elements.size() == 1;
    }

    /**
     * Turns the tree back into a heap, provided only the root node violates the heap condition
     */
    private void fixHeap() {
        T root = elements.get(1);

        int lastIndex = elements.size() - 1;

        // Promote children of removed root while they are smaller than root
        int index = 1;
        boolean more = true;
        while (more) {
            int childIndex = 2 * index;
            if (childIndex <= lastIndex) {
                // Get smaller child

                // Get left child first
                T child = elements.get(childIndex);

                // Use right child instead if it is smaller
                if (childIndex + 1 <= index && elements.get(childIndex + 1).compareTo(child) < 0) {
                    childIndex++;
                    child = elements.get(childIndex);
                }

                // Check if smaller child is smaller than root
                if (child.compareTo(root) < 0) {
                    // Promote child
                    elements.set(index, child);
                    index = childIndex;
                }
                else {
                    // Root is smaller than both children
                    more = false;
                }
            }
            else {
                // No children
                more = false;
            }
        }

        // Store root element in vacant slot
        elements.set(index, root);
    }

}
