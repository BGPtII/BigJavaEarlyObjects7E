package io.github.BGPtII.ch1introduction;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Asks the user for their restaurant bill & tip amount;
 * splits the total restaurant bill between a number of friends.
 * Prints the restaurant bill, the tip (15%) & total cost;
 * also prints what each person pays, and their part of the tip.
 */
public class RestaurantBillSplitter {
    public static void main(String[] args) {
        double bill;
        int numPeople;
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("Enter the restaurant bill total: ");
            try {
                bill = in.nextDouble();
                if (bill <= 0) {
                    throw new InputMismatchException();
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid positive number.");
                in.nextLine();
                continue;
            }
            break;
        }
        while (true);

        do {
            System.out.print("Enter the number of people splitting the bill: ");
            try {
                numPeople = in.nextInt();
                if (numPeople <= 0) {
                    throw new InputMismatchException();
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid positive integer.");
                in.nextLine();
                continue;
            }
            break;
        }
        while (true);

        System.out.println();
        System.out.printf("The restaurant bill is $%.2f%n", bill);
        double tip = 0.15 * bill;
        System.out.printf("The tip total is $%.2f%n", tip);
        System.out.printf("Each person pays $%.2f for the restaurant bill%n", bill / numPeople);
        System.out.printf("Each person pays $%.2f for their part of the tip%n", tip / numPeople);

        in.close();
    }
}
