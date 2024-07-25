package io.github.BGPtII.ch17treestructures;

public class BinaryTree<T> {

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(T rootData, BinaryTree<T> left, BinaryTree<T> right) {
        root = new Node();
        root.data = rootData;
        root.left = left.root;
        root.right = right.root;
    }

    class Node {

        public T data;
        public Node left;
        public Node right;

    }

    private int height(Node n) {
        if (n == null) {
            return 0;
        }
        return 1 + Math.max(height(n.left), height(n.right));
    }

    private int countNodesWithOneChild(Node n) {
        if (n == null) {
            return 0;
        }
        if ((n.right == null && n.left != null) || (n.left == null && n.right != null)) {
            return 1 + countNodesWithOneChild(n.left) + countNodesWithOneChild(n.right);
        }
        return countNodesWithOneChild(n.left) + countNodesWithOneChild(n.right);
    }

    /**
     * Uses a recursive depth-first search to swap child elements, from deepest to shallowest
     * @param n the node to start at
     */
    private void swapChildren(Node n) {
        if (n == null) {
            return;
        }
        swapChildren(n.left);
        swapChildren(n.right);
        Node temp = n.left;
        n.left = n.right;
        n.right = temp;
    }

    /**
     * Performs a preorder traversal on the specified node, and visits each node's data;
     * visits the node first, then recursively visits its left and right children
     * @param n the root of the (sub)tree
     * @param v the visitor
     */
    private void preorder(Node n, Visitor<T> v) {
        if (n == null) {
            return;
        }
        v.visit(n.data);
        preorder(n.left, v);
        preorder(n.right, v);
    }

    /**
     * Performs an inorder traversal on the specified node, and visits each node's data;
     * recursively visits the left child, the node itself, then the right child
     * @param n the root of the (sub) tree
     * @param v the visitor
     */
    private void inorder(Node n, Visitor<T> v) {
        if (n == null) {
            return;
        }
        inorder(n.left, v);
        v.visit(n.data);
        inorder(n.right, v);
    }

    /**
     * Stops visiting when ConditionalVisitor's visit() returns false
     * @param v the ConditionalVisitor
     */
    private boolean inorder(Node n, ConditionalVisitor<T> v) {
        if (n == null) {
            return true;
        }
        if (!inorder(n.left, v)) {
            return false;
        }
        if (v.visit(n.data)) {
            return false;
        }
        return inorder(n.right, v);
    }

    /**
     * Performs a postorder traversal on the specified node;
     * recursively visits the left and right children, then the node itself
     * @param n the root of the (sub) tree
     * @param v the visitor
     */
    private void postorder(Node n, Visitor<T> v) {
        if (n == null) {
            return;
        }
        postorder(n.left, v);
        postorder(n.right, v);
        v.visit(n.data);
    }

    public int height() {
        return height(root);
    }

    public int countNodesWithOneChild() {
        return countNodesWithOneChild(root);
    }

    public void swapChildren() {
        swapChildren(root);
    }

    public void preorder(Visitor<T> v) {
        preorder(root, v);
    }

    public void inorder(Visitor<T> v) {
        inorder(root, v);
    }

    public void inorder(ConditionalVisitor<T> v) {
        inorder(root, v);
    }

    public void postorder(Visitor<T> v) {
        postorder(root, v);
    }

}
