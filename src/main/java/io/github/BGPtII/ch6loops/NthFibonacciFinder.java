package io.github.BGPtII.ch6loops;

import java.util.Scanner;

/**
 * Asks the user for an integer, prints the user-defined nth iteration of the Fibonacci sequence
 * THIS ASSUMES THE FIBONACCI SEQUENCE STARTS AT 0 AT ITERATION 1, AND 1 ON ITERATIONS 2 & 3
 * EX: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610...
 */
public class NthFibonacciFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInt;
        int fold1 = 1;
        int fold2 = 1;
        int fibonacciResult = 0;
        System.out.println("Fibonacci Sequence Iteration Printer");
        System.out.print("Enter a whole number greater than 0 as the iteration #: ");
        if (scanner.hasNextInt()) {
            userInt = scanner.nextInt();
            if (userInt <= 0) {
                System.out.println("Invalid input: number must be greater than 0.");
            }
            else {
                if (userInt == 2 || userInt == 3) {
                    fibonacciResult = 1;
                }
                else if (userInt != 1) {
                    for (int i = 3; i < userInt; i++) {
                        fibonacciResult = fold1 + fold2;
                        fold2 = fold1;
                        fold1 = fibonacciResult;
                    }
                }
                System.out.println("Iteration #" + userInt + " of the Fibonacci sequence: " + fibonacciResult);
            }
        }
        else {
            System.out.println("Invalid input: MUST be a whole number greater than 0.");
        }
    }
}
