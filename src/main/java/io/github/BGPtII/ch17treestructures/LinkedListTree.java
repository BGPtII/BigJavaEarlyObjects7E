package io.github.BGPtII.ch17treestructures;

import io.github.BGPtII.ch16basicdatastructures.LinkedList;
import io.github.BGPtII.ch16basicdatastructures.Node;

/**
 * A tree in which each inner node has null data; implemented as a list of lists;
 * uses linked lists for the lists.
 */
public class LinkedListTree {

    private Object data;
    private LinkedList children;

    /**
     * Constructs an empty tree list
     */
    public LinkedListTree() {
        data = null;
        children = new LinkedList();
    }

    /**
     * Constructs a tree list with a single node
     * @param data the root data
     */
    public LinkedListTree(Object data) {
        this.data = data;
        children = new LinkedList();
    }

    public void addSubtree(LinkedListTree subtree) {
        children.addFirst(subtree);
    }

    public void addLeaf(Object leaf) {
        children.addFirst(new LinkedListTree(leaf));
    }

    @Override
    public String toString() {
        if (data != null) {
            return data.toString();
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        Node current = children.getFirstNode();
        boolean first = true;
        while (current != null) {
            Object child = current.getData();
            if (!first) {
                result.append(", ");
            }
            if (child instanceof LinkedListTree) {
                result.append(child);
            }
            else {
                result.append(child.toString());
            }
            current = current.getNext();
            first = false;
        }
        result.append("]");
        return result.toString();
    }

}
