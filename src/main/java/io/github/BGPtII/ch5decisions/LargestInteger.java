package io.github.BGPtII.ch5decisions;

import java.util.Scanner;

/**
 * User enters 3 integers, tells the user which integer is the largest.
 */
public class LargestInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] userInts = new int[3];

        for (int i = 0; i < userInts.length; i++) {
            System.out.print("Enter integer #" + (i + 1) + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Must enter an integer! Try again.");
                System.out.print("Enter integer #" + (i + 1) + ": ");
                scanner.next();
            }
            userInts[i] = scanner.nextInt();
        }
        scanner.close();

        int largestInt = userInts[0];
        for (int i = 1; i < userInts.length; i++) {
            if (userInts[i] > largestInt) {
                largestInt = userInts[i];
            }
        }
        System.out.println("Largest integer is: " + largestInt);
    }
}
