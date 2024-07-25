package io.github.BGPtII.ch4fundamentaldatatypes;

import java.util.Scanner;

/**
 * reads a number from the user and does the following: Discard all but the last three digits. Reverse the digits,
 * subtract the original from the reversed (discarding any minus sign), reverse the digits of the difference,
 * and add the difference and the reversed difference. Then prints the sum.
 */
public class Puzzle1089 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInteger = 0;

        do {
            System.out.print("Enter an integer that isn't 0 (\"q\" to quit): ");
            if (scanner.hasNext("q")) {
                System.exit(0);
            }
            if (scanner.hasNextInt()) {
                userInteger = scanner.nextInt();
            }
            else {
                scanner.next();
            }
        }
        while (userInteger == 0);

        userInteger = Integer.parseInt(String.valueOf(userInteger).substring(0, 3));
        System.out.println("Input: " + userInteger);

        int reverseInteger = Integer.parseInt(String.valueOf(new StringBuilder(String.valueOf(userInteger)).reverse()));
        System.out.println("Reversed: " + reverseInteger);

        userInteger -= reverseInteger;
        System.out.println("Difference (input - reversed with any minus discarded): " + userInteger);

        reverseInteger = Integer.parseInt(String.valueOf(new StringBuilder(String.valueOf(userInteger)).reverse()));
        System.out.println("Difference reversed: " + reverseInteger);

        userInteger += reverseInteger;
        System.out.println("Sum (difference + reversed): " + userInteger);
    }
}
