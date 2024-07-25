package io.github.BGPtII.ch6loops;

import java.util.Scanner;

public class PrimePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prime Numbers Printer");
        System.out.print("Enter a number to display the prime numbers up to & including: ");
        if (scanner.hasNextInt()) {
            int maxNumber = scanner.nextInt();
            PrimeGenerator primeGenerator = new PrimeGenerator();
            System.out.println("Prime numbers up to " + maxNumber + ":");
            int prime = primeGenerator.nextPrime();
            while (prime <= maxNumber) {
                System.out.print(prime + " ");
                prime = primeGenerator.nextPrime();
            }
        }
        else {
            System.out.println("Invalid input: not an integer.");
        }
    }
}
