package io.github.BGPtII.ch4fundamentaldatatypes;

import java.util.Scanner;

/**
 * A video club wants to reward its best members with a discount based on the member’s number of movie rentals and the number of new members referred by the member.
 * The discount is in percent and is equal to the sum of the rentals and the referrals, but it cannot exceed 75 percent
 */
public class DiscountCalculator {
    public static void main(String[] args) {
        int rentalCount = 0;
        int referredMemberCount = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            if (rentalCount <= 0) {
                System.out.print("Enter number of movie rentals (\"q\" to quit): ");
                if (scanner.hasNext("q")) {
                    System.exit(0);
                }
                if (scanner.hasNextInt()) {
                    rentalCount = scanner.nextInt();
                }
                else {
                    scanner.next();
                }
            }
            if (referredMemberCount <= 0) {
                System.out.print("Enter number of referred members (\"q\" to quit): ");
                if (scanner.hasNext("q")) {
                    System.exit(0);
                }
                if (scanner.hasNextInt()) {
                    referredMemberCount = scanner.nextInt();
                }
                else {
                    scanner.next();
                }
            }
        }
        while (rentalCount <= 0 || referredMemberCount <= 0);

        int discountPercentage = Math.min(75, rentalCount + referredMemberCount);
        System.out.println("The discount is equal to: " + discountPercentage + "%.");
    }
}
