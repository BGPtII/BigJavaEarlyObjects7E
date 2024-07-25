package io.github.BGPtII.ch6loops;

import java.util.Scanner;

/**
 * Finds the minimum value from a set of user-entered numbers
 */
public class MinimumNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double smallest = Double.POSITIVE_INFINITY;

        System.out.println("Enter numbers, type 'done' to finish:");
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                double input = scanner.nextDouble();
                smallest = Math.min(smallest, input);
            }
            else if (scanner.next().equalsIgnoreCase("done")) {
                break;
            }
            else {
                System.out.println("Invalid input. Enter a number or 'done'.");
            }
        }

        System.out.println("Smallest number: " + smallest);
    }
}
