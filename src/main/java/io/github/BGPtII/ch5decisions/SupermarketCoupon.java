package io.github.BGPtII.ch5decisions;

import java.util.Scanner;

/**
 * A supermarket awards coupons depending on how much a customer spends on groceries; the criteria is as follows:
 * Less than $10 - No coupon
 * From $10 to $60 - 8%
 * More than $60 to $150 - 10%
 * More than $150 to $210 - 12%
 * More than $210 - 14%
 */
public class SupermarketCoupon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double groceryCost = 0;

        while (groceryCost <= 0) {
            System.out.print("Please enter the cost of your groceries: ");
            if (scanner.hasNextDouble()) {
                groceryCost = scanner.nextDouble();
                if (groceryCost <= 0) {
                    System.out.println("Cost must be greater than zero. Please try again.");
                }
            }
            else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }

        double couponDiscount = 0;
        if (groceryCost > 210) {
            couponDiscount = 0.14;
        }
        else if (groceryCost > 150) {
            couponDiscount = 0.12;
        }
        else if (groceryCost > 60) {
            couponDiscount = 0.1;
        }
        else if (groceryCost > 10) {
            couponDiscount = 0.08;
        }

        if (couponDiscount == 0) {
            System.out.println("$0 worth of groceries means no coupon.");
        }
        else {
            double discountAmount = couponDiscount * groceryCost;
            System.out.printf("You win a discount coupon of $%.2f. (%d%% of your purchase)%n", discountAmount, (int) (couponDiscount * 100));
        }
        scanner.close();
    }
}
