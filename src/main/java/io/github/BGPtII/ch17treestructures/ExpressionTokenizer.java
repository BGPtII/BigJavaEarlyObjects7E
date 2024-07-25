package io.github.BGPtII.ch17treestructures;

/**
 * Breaks up a string describing an expression into tokens:
 * numbers, parentheses, and operators
 */
public class ExpressionTokenizer {
    private String input;
    private int start; // The start of the current token
    private int end; // The position after the end of the current token

    /**
     * Constructs a tokenizer
     */
    public ExpressionTokenizer(String input) {
        this.input = input;
        start = 0;
        end = 0;
        nextToken(); // Find the first token
    }

    /**
     * Peeks at the next token without consuming it
     * @return the next token or null if there are no more tokens
     */
    public String peekToken() {
        if (start >= input.length()) {
            return null;
        }
        return input.substring(start, end);
    }

    /**
     * Gets the next token and moves the tokenizer to the following token
     * @return the next token or null if there are no more tokens
     */
    public String nextToken() {
        String r = peekToken();
        start = end;
        if (start >= input.length()) {
            return r;
        }
        if (Character.isDigit(input.charAt(start))) {
            end = start + 1;
            while (end < input.length() && Character.isDigit(input.charAt(end))) {
                end++;
            }
        }
        else {
            end = start + 1;
        }
        return r;
    }

}
