package io.github.BGPtII.ch4fundamentaldatatypes;

import java.util.Scanner;

/**
 * Gets an integer from the user, then prints the individual digits
 * Integer must be positive & less than 6 digits
 * EX: 16384 is displayed as "1 6 3 8 4"
 */
public class IntegerToDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userNumber;

        while (true) {
            System.out.print("Enter a positive integer less than 100000 (\"q\" to quit): ");
            if (scanner.hasNextInt()) {
                userNumber = scanner.nextInt();
                if (userNumber > 0 && userNumber < 100000) {
                    printDigits(userNumber);
                }
                else {
                    System.out.println("Please enter a positive integer less than 100000.");
                }
            }
            else if (scanner.hasNext("q")) {
                System.out.println("Exiting the program.");
                break;
            }
            else {
                System.out.println("Invalid input. Please enter a positive integer less than 100000.");
                scanner.next(); // Consume invalid input
            }
        }
        scanner.close();
    }

    private static void printDigits(int number) {
        System.out.print("Your digits: ");
        // Extract and print each digit from the number
        while (number > 0) {
            int digit = number % 10; // Extract the last digit
            System.out.print(digit + " ");
            number /= 10; // Remove the last digit
        }
        System.out.println();
    }
}
