package io.github.BGPtII.ch15javacollectionsframework;

import java.util.Scanner;
import java.util.Stack;

/**
 * Prompts the user for an integer & prints the individual digits.
 * Doesn't take into the account "-" in negative integers (converts negative numbers into positive ones).
 */
public class SplitIntegerIntoDigits {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Get the Individual Digits of an Integer");
        System.out.println("Will ignore the negative association with a negative integer.");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter an integer: ");
            if (scanner.hasNextInt()) {
                int n = Math.abs(scanner.nextInt());
                if (n == 0) {
                    stack.push(0);
                }
                else {
                    while (n > 0) {
                        stack.push(n % 10);
                        n /= 10;
                    }
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop());
                        if (!stack.isEmpty()) {
                            System.out.print(", ");
                        }
                    }
                }
            }
            else {
                System.out.println("Not an integer.");
            }
        }
    }

}
