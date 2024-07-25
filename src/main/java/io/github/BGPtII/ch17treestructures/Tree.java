package io.github.BGPtII.ch17treestructures;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

    private Node root;

    class Node {

        public T data;
        public List<Node> children;

        public int size() {
            int sum = 0;
            for (Node child : children) {
                sum += child.size();
            }
            return 1 + sum;
        }

        public int getLeafCount() {
            if (children.isEmpty()) {
                return 1;
            }
            int count = 0;
            for (Node child : children) {
                count += child.getLeafCount();
            }
            return count;
        }

    }

    public Tree(T rootData) {
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<>();
    }

    /**
     * Uses the depth-first search algorithm, stops when visit returns false
     * @param v the visitor
     */
    private boolean depthFirst(Node n, ConditionalVisitor<T> v) {
        if (n == null) {
            return true;
        }
        if (!v.visit(n.data)) {
            return false;
        }
        for (Node c : n.children) {
            if (!depthFirst(c, v)) {
                return false;
            }
        }
        return true;
    }

    public void addSubtree(Tree<T> subtree) {
        root.children.add(subtree.root);
    }

    public int size() {
        if (root == null) {
            return 0;
        }
        return root.size();
    }

    public int getLeafCount() {
        if (root == null) {
            return 0;
        }
        return root.getLeafCount();
    }

    public void depthFirst(ConditionalVisitor<T> v) {
        depthFirst(root, v);
    }

}
