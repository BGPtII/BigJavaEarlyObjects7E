package io.github.BGPtII.ch17treestructures;

/**
 * Rules:
 * 1) Every node is coloured red or black.
 * 2) The root is black.
 * 4) A red node can not have a red child.
 * 5) All paths from root to null have the same number of black nodes (equal exist cost).
 * @param <T> the type of the objects stored as data in the nodes
 */
public class RedBlackTree<T extends Comparable<T>> {

    private static final int BLACK = 1;
    private static final int RED = 0;
    private static final int NEGATIVE_RED = -1;
    private static final int DOUBLE_BLACK = 2;

    private Node root;

    class Node {

        public T data;
        public Node left;
        public Node right;
        public Node parent;
        public int colour;

        /**
         * Sets the right child and updates its parent reference
         * @param child the new left child
         */
        public void setLeftChild(Node child) {
            left = child;
            if (child != null) {
                child.parent = this;
            }
        }

        /**
         * Sets the right child and updates its parent reference
         * @param child the new right child
         */
        public void setRightChild(Node child) {
            right = child;
            if (child != null) {
                child.parent = this;
            }
        }

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

    }

    /**
     * Updates the parent's and replacement node's links when a node is replaced
     * @param toBeReplaced the node that is to be replaced
     * @param replacement the node that replaces the node
     */
    private void replaceWith(Node toBeReplaced, Node replacement) {
        if (toBeReplaced == null) {
            replacement.parent = null;
            root = replacement;
        }
        else if (toBeReplaced == toBeReplaced.parent.left) {
            toBeReplaced.parent.setLeftChild(replacement);
        }
        else {
            toBeReplaced.parent.setRightChild(replacement);
        }
    }

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
        fixAfterAdd(newNode);
    }

    private void fixAfterAdd(Node newNode) {
        if (newNode.parent == null) {
            newNode.colour = BLACK;
        }
        else {
            newNode.colour = RED;
            if (newNode.parent.colour == RED) {
                fixDoubleRed(newNode);
            }
        }
    }

    /**
     * Fixes a "double red" violation
     * @param child the child with a red parent
     */
    private void fixDoubleRed(Node child) {
        Node parent = child.parent;
        Node grandParent = parent.parent;
        if (grandParent == null) {
            parent.colour = BLACK;
            return;
        }
        Node n1, n2, n3, t1, t2, t3, t4;
        if (parent == grandParent.left) {
            n3 = grandParent;
            t4 = grandParent.right;
            if (child == parent.left) {
                n1 = child;
                n2 = parent;
                t1 = child.left;
                t2 = child.right;
                t3 = parent.right;
            }
            else {
                n1 = parent;
                n2 = child;
                t1 = parent.left;
                t2 = child.left;
                t3 = child.right;
            }
        }
        else {
            n1 = grandParent;
            t1 = grandParent.left;
            if (child == parent.left) {
                n2 = child;
                n3 = parent;
                t2 = child.left;
                t3 = child.right;
                t4 = parent.right;
            }
            else {
                n2 = parent;
                n3 = child;
                t2 = parent.left;
                t3 = child.left;
                t4 = child.right;
            }
        }

        replaceWith(grandParent, n2);
        n1.setLeftChild(t1);
        n1.setRightChild(t2);
        n2.setLeftChild(n1);
        n2.setRightChild(n3);
        n3.setLeftChild(t3);
        n3.setRightChild(t4);
        n2.colour = grandParent.colour - 1;
        n1.colour = BLACK;
        n3.colour = BLACK;

        if (n2 == root) {
            root.colour = BLACK;
        }
        else if (n2.colour == RED && n2.parent.colour == RED) {
            fixDoubleRed(n2);
        }
    }

    public void remove(T obj) {
        // Find node to be removed

        Node toBeRemoved = root;
        boolean found = false;
        while (!found && toBeRemoved != null) {
            int d = toBeRemoved.data.compareTo(obj);
            if (d == 0) {
                found = true;
            }
            else {
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

            fixBeforeRemove(toBeRemoved);
            replaceWith(toBeRemoved, newChild);
            return;
        }

        // Neither subtree is empty

        // Find the smallest element of the right subtree

        Node smallest = toBeRemoved.right;
        while (smallest.left != null) {
            smallest = smallest.left;
        }

        // smallest contains smallest child in right subtree

        // Move contents, unlink child

        toBeRemoved.data = smallest.data;
        fixBeforeRemove(smallest);
        replaceWith(smallest, smallest.right);
    }

    /**
     * Fixes the tree so that it is a red-black tree after a node has been removed
     * @param toBeRemoved the node that is to be removed
     */
    private void fixBeforeRemove(Node toBeRemoved) {
        if (toBeRemoved.colour == RED) {
            return;
        }

        if (toBeRemoved.left != null || toBeRemoved.right != null) { // It is not a leaf
            // Colour the child black
            if (toBeRemoved.left == null) {
                toBeRemoved.right.colour = BLACK;
            }
            else {
                bubbleUp(toBeRemoved.parent);
            }
        }
    }

    /**
     * Move a charge from two children of a parent
     * @param parent a node with two children, or null (in which case nothing is done)
     */
    private void bubbleUp(Node parent) {
        if (parent == null) {
            return;
        }
        parent.colour++;
        parent.left.colour--;
        parent.right.colour--;

        if (bubbleUpFix(parent.left)) {
            return;
        }
        if (bubbleUpFix(parent.right)) {
            return;
        }

        if (parent.colour == DOUBLE_BLACK) {
            if (parent.parent == null) {
                parent.colour = BLACK;
            }
            else {
                bubbleUp(parent.parent);
            }
        }
    }

    /**
     * Fixes a negative-red or double-red violation introduced by bubbling up
     * @param child the child to check for negative-red or double-red violations
     * @return whether the tree was fixed
     */
    private boolean bubbleUpFix(Node child) {
        if (child.colour == NEGATIVE_RED) {
            fixNegativeRed(child);
            return true;
        }
        else if (child.colour == RED) {
            if (child.left != null && child.left.colour == RED) {
                fixDoubleRed(child.left);
                return true;
            }
            if (child.right != null && child.right.colour == RED) {
                fixDoubleRed(child.right);
                return true;
            }
        }
        return false;
    }

    /**
     * Fixes a "negative red" violation
     * @param negRed the negative red node
     */
    private void fixNegativeRed(Node negRed) {
        Node parent = negRed.parent;
        Node child;
        if (parent.left == negRed) {
            Node n1 = negRed.left;
            Node n3 = negRed.right;
            Node t1 = n3.left;
            Node t2 = n3.right;
            Node t3 = parent.right;
            n1.colour = RED;
            negRed.colour = BLACK;
            parent.colour = BLACK;

            replaceWith(parent, n3);
            n3.setLeftChild(negRed);
            n3.setRightChild(parent);
            negRed.setLeftChild(n1);
            negRed.setRightChild(t1);
            parent.setLeftChild(t2);
            parent.setRightChild(t3);

            child = n1;
        }
        else { // Mirror image
            Node n4 = negRed.right;
            Node n2 = negRed.left;
            Node t3 = n2.right;
            Node t2 = n2.left;
            Node t1 = parent.left;
            n4.colour = RED;
            negRed.colour = BLACK;
            parent.colour = BLACK;

            replaceWith(parent, n2);
            n2.setRightChild(negRed);
            n2.setLeftChild(parent);
            negRed.setRightChild(n4);
            negRed.setLeftChild(t3);
            parent.setRightChild(t2);
            parent.setLeftChild(t1);

            child = n4;
        }

        if (child.left != null && child.left.colour == RED) {
            fixDoubleRed(child.left);
        }
        else if (child.right != null && child.right.colour == RED) {
            fixDoubleRed(child.right);
        }
    }

}
