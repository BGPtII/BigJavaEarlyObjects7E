package io.github.BGPtII.ch17treestructures;

import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    private Node addNode(Node parent, Node newNode) {
        if (parent == null) {
            return newNode;
        }

        int comp = newNode.data.compareTo(parent.data);
        if (comp < 0) {
            parent.left = addNode(parent.left, newNode);
        }
        else if (comp > 0) {
            parent.right = addNode(parent.right, newNode);
        }
        return parent;
    }

    /**
     * Inserts a new node into the tree
     * @param obj the object to the insert
     */
    public void add(T obj) {
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;
        if (root == null) {
            root = newNode;
        }
        else {
            root.addNode(newNode);
        }
    }

    /**
     * Tries to find an object in the tree
     * @param obj the object to find
     * @return whether the object is contained in the tree
     */
    public boolean find(T obj) {
        Node current = root;
        while (current != null) {
            int d = current.data.compareTo(obj);
            if (d == 0) {
                return true;
            }
            else if (d > 0) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        return false;
    }

    /**
     * Tries to remove an object from the tree; does nothing if the object is not contained in the tree
     * @param obj the object to remove
     */
    public void remove(T obj) {
        // Find node to be removed
        Node toBeRemoved = root;
        Node parent = null;
        boolean found = false;
        while (!found && toBeRemoved != null) {
            int d = toBeRemoved.data.compareTo(obj);
            if (d == 0) {
                found = true;
            }
            else {
                parent = toBeRemoved;
                if (d > 0) {
                    toBeRemoved = toBeRemoved.left;
                }
                else {
                    toBeRemoved = toBeRemoved.right;
                }
            }
        }

        if (!found) {
            return;
        }

        // toBeRemoved contains obj
        // If one of the children is empty, use the other
        if (toBeRemoved.left == null || toBeRemoved.right == null) {
            Node newChild;
            if (toBeRemoved.left == null) {
                newChild = toBeRemoved.right;
            }
            else {
                newChild = toBeRemoved.left;
            }

            if (parent == null) { // Found in root
                root = newChild;
            }
            else if (parent.left == toBeRemoved) {
                parent.left = newChild;
            }
            else {
                parent.right = newChild;
            }
            return;
        }

        // Neither subtree is empty
        // Find the smallest element of the right subtree
        Node smallestParent = toBeRemoved;
        Node smallest = toBeRemoved.right;
        while (smallest.left != null) {
            smallestParent = smallest;
            smallest = smallest.left;
        }

        // Smallest contains smallest child in right subtree
        // Move contents, unlink child
        toBeRemoved.data = smallest.data;
        if (smallestParent == toBeRemoved) {
            smallestParent.right = smallest.right;
        }
        else {
            smallestParent.left = smallest.right;
        }
    }

    /**
     * Gets the smallest element
     * @return the smallest element
     */
    public T smallest() {
        if (root == null) { // Tree is empty
            throw new NoSuchElementException();
        }
        return root.smallest().data;
    }

    class Node {

        public T data;
        public Node left;
        public Node right;

        public void addNode(Node newNode) {
            int comp = newNode.data.compareTo(data);
            if (comp < 0) {
                if (left == null) {
                    left = newNode;
                }
                else {
                    left.addNode(newNode);
                }
            }
            else if (comp > 0) {
                if (right == null) {
                    right = newNode;
                }
                else {
                    right.addNode(newNode);
                }
            }
        }

        public Node smallest() {
            if (left != null) {
                left.smallest();
            }
            return this;
        }

    }

}
