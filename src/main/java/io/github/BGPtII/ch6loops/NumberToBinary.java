package io.github.BGPtII.ch6loops;

import java.util.Scanner;

public class NumberToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter any number: ");

        if (scanner.hasNextDouble()) {
            double userNumber = scanner.nextDouble();
            int integerPart = (int) userNumber;
            double decimalPart = userNumber - integerPart;

            StringBuilder binaryConversion = new StringBuilder();

            if (integerPart == 0) {
                binaryConversion.append(0);
            }
            else {
                if (integerPart < 0) {
                    binaryConversion.append("-");
                    integerPart = Math.abs(integerPart);
                }
                binaryConversion.append(Integer.toBinaryString(integerPart));
            }

            if (decimalPart != 0) {
                binaryConversion.append(".");
                for (int i = 0; i < 10; i++) {
                    decimalPart *= 2;
                    int bit = (int) decimalPart;
                    binaryConversion.append(bit);
                    decimalPart -= bit;
                }
            }

            System.out.println("Converted binary: " + binaryConversion);
        }
        else {
            System.out.println("Only numbers accepted!");
        }
    }
}
