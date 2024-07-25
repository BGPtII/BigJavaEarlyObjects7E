package io.github.BGPtII.ch17treestructures;

import io.github.BGPtII.ch17treestructures.BinaryTree;

import java.util.Stack;

/**
 * A class for building and evaluating a binary expression tree.
 * The leaves of the tree contain integers, while the interior nodes contain operators.
 */
public class ExpressionTree {

    private ExpressionTokenizer tokenizer;
    private BinaryTree<String> expressionTree;

    /**
     * Constructs an ExpressionTree from the given expression.
     * The expression must not contain any spaces, it as well as any parentheses must be properly closed,
     * and numbers must be valid integers.
     * Example expressions: "3+4-4*2" or "3+4*2-(1+2)*3"
     * @param expression the expression to use for constructing the tree
     */
    public ExpressionTree(String expression) {
        buildExpressionTree(expression);
    }

    /**
     * Builds the binary expression tree from the given expression
     * @param expression the expression to use for constructing the tree
     */
    public void buildExpressionTree(String expression) {
        tokenizer = new ExpressionTokenizer(expression);
        expressionTree = buildExpressionTreeHelper();
    }

    /**
     * Helper method to build the expression tree recursively.
     * This method handles terms separated by addition or subtraction operators.
     * @return the root of the constructed binary tree
     */
    private BinaryTree<String> buildExpressionTreeHelper() {
        BinaryTree<String> tree = buildTermTree();
        boolean done = false;
        while (!done) {
            String next = tokenizer.peekToken();
            if ("+".equals(next) || "-".equals(next)) {
                String operator = tokenizer.nextToken();
                BinaryTree<String> right = buildTermTree();
                tree = new BinaryTree<>(operator, tree, right);
            }
            else {
                done = true;
            }
        }
        return tree;
    }

    /**
     * Helper method to build the term tree.
     * This method handles factors separated by multiplication or division operators.
     * @return the root of the constructed binary tree
     */
    private BinaryTree<String> buildTermTree() {
        BinaryTree<String> tree = buildFactorTree();
        boolean done = false;
        while (!done) {
            String next = tokenizer.peekToken();
            if ("*".equals(next) || "/".equals(next)) {
                String operator = tokenizer.nextToken();
                BinaryTree<String> right = buildFactorTree();
                tree = new BinaryTree<>(operator, tree, right);
            }
            else {
                done = true;
            }
        }
        return tree;
    }

    /**
     * Helper method to build the factor tree.
     * This method handles individual factors, which may be numbers or expressions enclosed in parentheses.
     * @return the root of the constructed binary tree
     */
    private BinaryTree<String> buildFactorTree() {
        String next = tokenizer.peekToken();
        if ("(".equals(next)) {
            tokenizer.nextToken(); // Discard "("
            BinaryTree<String> tree = buildExpressionTreeHelper();
            tokenizer.nextToken(); // Discard ")"
            return tree;
        }
        else {
            return new BinaryTree<>(tokenizer.nextToken(), new BinaryTree<>(), new BinaryTree<>());
        }
    }

    /**
     * Evaluates the constructed expression tree
     * @return the result of the computation
     * @throws IllegalStateException if the expression tree has not been built yet
     */
    public int evaluateExpression() {
        if (expressionTree == null) {
            throw new IllegalStateException("Expression tree has not been built yet.");
        }
        return evaluatePostOrder(expressionTree);
    }

    /**
     * Evaluates the expression tree using a post-order traversal
     * @param tree the root of the binary tree to evaluate
     * @return the result of the computation
     */
    private int evaluatePostOrder(BinaryTree<String> tree) {
        Stack<Integer> stack = new Stack<>();
        tree.postorder(data -> {
            if (isOperator(data)) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(applyOperator(data, left, right));
            }
            else {
                stack.push(Integer.parseInt(data));
            }
        });
        return stack.pop();
    }

    /**
     * Checks if the token is an operator
     * @param token the token to check
     * @return whether the token is an operator
     */
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    /**
     * Applies the given operator to the left and right operands
     * @param operator the operator to apply
     * @param left the left operand
     * @param right the right operand
     * @return the result of applying the operator to the operands
     * @throws IllegalArgumentException if the operator is unknown or not supported
     */
    private int applyOperator(String operator, int left, int right) {
        return switch (operator) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> left / right;
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }

}
