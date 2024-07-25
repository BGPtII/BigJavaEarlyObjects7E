package io.github.BGPtII.ch5decisions;

import java.util.Scanner;

/**
 * Prompts the user for their 4-digit PIN # (the correct PIN is defined as "correctPin" within the main method
 * If the user enters the right number, prints a message saying, “Your PIN is correct”, and end the program
 * If the user enters a wrong number, print a message saying, “Your PIN is incorrect” and, if you have asked for the PIN less than three times, asks for it again
 * If the user enters a wrong number three times, print a message saying “Your bank card is blocked” and ends the program
 */
public class PINVerificationATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String correctPin = "1234"; // Example PIN for application - can modify, but MUST be a 4-digit String of integers
        int attemptsLeft = 3;
        boolean runApp = true;

        while (runApp) {
            System.out.print("Enter your bank PIN (attempts left " + attemptsLeft + "): ");
            String attemptedPIN = scanner.nextLine();
            if (attemptedPIN.matches("[0-9]+")) {
                if (attemptedPIN.length() == 4) {
                    if (attemptedPIN.equals(correctPin)) {
                        System.out.println("Your PIN is correct!");
                        break;
                    }
                    else {
                        attemptsLeft--;
                        System.out.println("Your PIN is incorrect!");
                        if (attemptsLeft == 0) {
                            System.out.println("Your bank card is blocked.");
                            break;
                        }
                    }
                }
                else {
                    System.out.println("PIN must only be 4 digits!");
                }
            }
            else {
                System.out.println("PIN can only consist of whole, non-negative numbers!");
            }
        }
    }
}
