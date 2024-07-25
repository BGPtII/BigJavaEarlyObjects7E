package io.github.BGPtII.ch17treestructures;

public class NumberBinaryTree<T extends Number> extends BinaryTree<T> {

    public NumberBinaryTree() {
        super();
    }

    public NumberBinaryTree(T rootData, NumberBinaryTree<T> left, NumberBinaryTree<T> right) {
        super(rootData, left, right);
    }

    public double average() {
        AverageCalculatorVisitor v = new AverageCalculatorVisitor();
        postorder(v);
        return v.average();
    }
    
    class AverageCalculatorVisitor implements Visitor<T> {
        private int count;
        private double sum;

        public AverageCalculatorVisitor() {
            count = 0;
            sum = 0;
        }

        @Override
        public void visit(T data) {
            count++;
            sum += data.doubleValue();
        }

        public double average() {
            if (count == 0) {
                return 0;
            }
            return sum / count;
        }

    }

}
