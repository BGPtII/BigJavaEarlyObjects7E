package io.github.BGPtII.ch5decisions;

import java.util.Scanner;

/**
 * User enters meal price, then selects their level of satisfaction between 3 options:
 * 1 - totally satisfied (20% tip), 2 - satisfied (15% tip), 3- dissatisfied (10% tip)
 * Prints the tip in dollars & cents
 */
public class RestaurantSatisfactionTip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double mealPrice = 0;
        double tipRate = 0;

        System.out.println("Restaurant Tip Calculator | Satisfaction-Level-Based");
        System.out.println("Enter \"q\" at any prompt to quit the application.");
        while (mealPrice <=0 || tipRate == 0) {
            if (mealPrice <= 0) {
                System.out.print("Enter total meal price: ");
                if (scanner.hasNext("q")) {
                    System.out.println("Exiting application...");
                    break;
                }
                if (scanner.hasNextDouble()) {
                    double input = scanner.nextDouble();
                    if (input > 0) {
                        mealPrice = input;
                    }
                    else {
                        System.out.println("Meal price must be greater than 0.");
                    }
                }
                else {
                    System.out.println("Meal price must be a number greater than 0.");
                    scanner.next();
                }
            }
            else if (tipRate == 0) {
                System.out.println("Satisfaction Level Options");
                System.out.println("1. Totally Satisfied");
                System.out.println("2. Satisfied");
                System.out.println("3. Dissatisfied");
                System.out.print("Enter satisfaction option number: ");
                if (scanner.hasNext("q")) {
                    System.out.println("Exiting application...");
                    break;
                }
                else if (scanner.hasNextInt()) {
                    int option = scanner.nextInt();
                    if (option == 1) {
                        tipRate = 0.20;
                    }
                    else if (option == 2) {
                        tipRate = 0.15;
                    }
                    else if (option == 3) {
                        tipRate = 0.1;
                    }
                    else {
                        System.out.println("Satifaction option must be either: 1, 2 OR 3.");
                    }
                }
                else {
                    System.out.println("Satisfaction option must be either: 1, 2 OR 3.");
                    scanner.next();
                }
            }
        }
        System.out.printf("The tip: $%.2f", tipRate * mealPrice);
    }
}
