package io.github.BGPtII.ch17treestructures;

public class LinkedListTreeDemo {

    public static void main(String[] args) {
        LinkedListTree root = new LinkedListTree();
        LinkedListTree subtree2 = new LinkedListTree();
        subtree2.addLeaf("D");
        root.addSubtree(subtree2);
        root.addLeaf("C");
        LinkedListTree subtree1 = new LinkedListTree();
        subtree1.addLeaf("B");
        subtree1.addLeaf("A");
        root.addSubtree(subtree1);
        System.out.println(root);
        System.out.println();

        root = new LinkedListTree();
        LinkedListTree subtree3 = new LinkedListTree();
        LinkedListTree subtree3Subtree = new LinkedListTree();
        subtree3Subtree.addLeaf("Z");
        subtree3.addSubtree(subtree3Subtree);
        root.addSubtree(subtree3);
        root.addLeaf("Y");
        subtree2 = new LinkedListTree();
        subtree2.addLeaf("X");
        root.addSubtree(subtree2);
        subtree1 = new LinkedListTree();
        subtree1.addLeaf("W");
        root.addSubtree(subtree1);
        System.out.println(root);
    }

}
