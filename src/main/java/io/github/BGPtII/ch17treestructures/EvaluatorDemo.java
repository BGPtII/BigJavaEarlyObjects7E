package io.github.BGPtII.ch17treestructures;

public class EvaluatorDemo {

    public static void main(String[] args) {
        String expression = "3+4*2-(1+2)*3";
        ExpressionTree expressionTree = new ExpressionTree(expression);
        System.out.println("Expression: " + expression);
        System.out.println("Result: " + expressionTree.evaluateExpression());
        System.out.println();

        expression = "3+4-1";
        expressionTree = new ExpressionTree(expression);
        System.out.println("Expression: " + expression);
        System.out.println("Result: " + expressionTree.evaluateExpression());
        System.out.println();
    }
}
