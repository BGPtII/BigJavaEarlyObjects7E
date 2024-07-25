package io.github.BGPtII.ch4fundamentaldatatypes;

import java.util.Scanner;

public class BookStore {
    private static final double TAX_RATE = 0.075;
    private static final double SHIPPING_CHARGE_PER_BOOK = 2.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numBooks = getNumberOfBooks(scanner);
        double totalBookPrice = getTotalPriceOfBooks(scanner);

        double totalPrice = calculateTotalPrice(numBooks, totalBookPrice);
        System.out.printf("Total price is: $%.2f%n", totalPrice);

        scanner.close();
    }

    private static int getNumberOfBooks(Scanner scanner) {
        int numBooks = 0;
        while (numBooks <= 0) {
            System.out.print("Enter number of books ordered (\"q\" to quit): ");
            if (scanner.hasNextInt()) {
                numBooks = scanner.nextInt();
                if (numBooks <= 0) {
                    System.out.println("Please enter a positive number of books.");
                }
            }
            else if (scanner.hasNext("q")) {
                System.exit(0);
            }
            else {
                System.out.println("Invalid input. Please enter a positive integer or \"q\" to quit.");
                scanner.next();
            }
        }
        return numBooks;
    }

    private static double getTotalPriceOfBooks(Scanner scanner) {
        double totalBookPrice = 0;
        while (totalBookPrice <= 0) {
            System.out.print("Enter total price of books (\"q\" to quit): ");
            if (scanner.hasNextDouble()) {
                totalBookPrice = scanner.nextDouble();
                if (totalBookPrice <= 0) {
                    System.out.println("Please enter a positive total price of books.");
                }
            }
            else if (scanner.hasNext("q")) {
                System.exit(0);
            }
            else {
                System.out.println("Invalid input. Please enter a positive number or \"q\" to quit.");
                scanner.next();
            }
        }
        return totalBookPrice;
    }

    private static double calculateTotalPrice(int numBooks, double totalBookPrice) {
        double tax = TAX_RATE * totalBookPrice;
        double shippingCharge = SHIPPING_CHARGE_PER_BOOK * numBooks;
        return totalBookPrice + tax + shippingCharge;
    }
}
