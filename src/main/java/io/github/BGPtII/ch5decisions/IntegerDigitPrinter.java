package io.github.BGPtII.ch5decisions;

import java.util.Scanner;

/**
 * Reads an integer and prints how many digits the number has.
 * If the number is negative, first multiply it with –1
 */
public class IntegerDigitPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInteger;

        do {
            System.out.print("Enter an integer (\"q\" to quit): ");
            if (scanner.hasNextInt()) {
                userInteger = scanner.nextInt();
                if (userInteger != 0) {
                    int digitCount = countDigits(Math.abs(userInteger));
                    System.out.printf("The number %d has %d digit(s).%n", userInteger, digitCount);
                }
            }
            else if (scanner.hasNext("q")) {
                System.exit(0);
            }
            else {
                scanner.next();
            }
        } while (true);
    }

    private static int countDigits(int number) {
        return (number == 0) ? 1 : (int) Math.log10(number) + 1;
    }
}

