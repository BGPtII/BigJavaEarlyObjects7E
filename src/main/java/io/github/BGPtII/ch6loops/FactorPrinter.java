package io.github.BGPtII.ch6loops;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FactorPrinter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberToFactor = getValidInput(scanner);
            FactorGenerator factorGenerator = new FactorGenerator(numberToFactor);
            printFactors(numberToFactor, factorGenerator);
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input: not an integer.");
        }
    }

    private static int getValidInput(Scanner scanner) {
        System.out.println("Factor Generator");
        System.out.print("Enter an integer to find factors of: ");
        return scanner.nextInt();
    }

    private static void printFactors(int numberToFactor, FactorGenerator factorGenerator) {
        System.out.print("Factors of " + numberToFactor + ": ");
        if (numberToFactor == 0) {
            System.out.println("0 has no factors.");
        }
        else {
            while (factorGenerator.hasMoreFactors()) {
                System.out.print(factorGenerator.nextFactor());
                if (factorGenerator.hasMoreFactors()) {
                    System.out.print(", ");
                }
            }
        }
    }
}
