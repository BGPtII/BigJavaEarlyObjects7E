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

    private Node root;

    public RedBlackTree() {
        root = null;
    }

    private boolean isRed(Node node) {
        return node != null && node.nodeColour == NodeColour.RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.nodeColour = h.nodeColour;
        h.nodeColour = NodeColour.RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.nodeColour = h.nodeColour;
        h.nodeColour = NodeColour.RED;
        return x;
    }

    private void flipColours(Node h) {
        h.nodeColour = NodeColour.RED;
        h.left.nodeColour = NodeColour.BLACK;
        h.right.nodeColour = NodeColour.BLACK;
    }

    private Node insertNode(Node current, T data) {
        if (current == null) {
            Node newNode = new Node();
            newNode.data = data;
            newNode.nodeColour = NodeColour.RED; // New nodes are initially red
            return newNode;
        }

        int c = data.compareTo(current.data);
        if (c < 0) {
            current.left = insertNode(current.left, data);
        }
        else if (c > 0) {
            current.right = insertNode(current.right, data);
        }
        else { // Duplicate data, do nothing
            return current;
        }

        // Fix all possible rule violations
        if (isRed(current.right) && !isRed(current.left)) {
            current = rotateLeft(current);
        }
        if (isRed(current.left) && isRed(current.left.left)) {
            current = rotateRight(current);
        }
        if (isRed(current.left) && isRed(current.right)) {
            flipColours(current);
        }

        return current;
    }

    public void insertNode(T data) {
        root = insertNode(root, data);
        root.nodeColour = NodeColour.BLACK; // Root must be black
    }

    class Node {

        T data;
        Node left;
        Node right;
        NodeColour nodeColour;

    }

    enum NodeColour {
        RED,
        BLACK
    }

}
