package io.github.BGPtII.ch7arraysandarraylists;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Computes the alternating sum of all elements in an array.
 * For example, if your program reads the input: 1 4 9 16 9 7 4 9 11,
 * then it computes: 1 – 4 + 9 – 16 + 9 – 7 + 4 – 9 + 11 = –2
 */
public class AlternatingSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<>();
        double alternatedSum = 0;

        while (true) {
            System.out.print("Enter a number ('q' to exit number adding prompt): ");
            if (scanner.hasNext("q")) {
                System.out.println("Finished adding numbers.");
                break;
            }
            else if (scanner.hasNextDouble()) {
                numbers.add(scanner.nextDouble());
            }
            else {
                System.out.println("Invalid input, numbers only.");
                scanner.next();
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("No numbers entered.");
        }
        else {
            if (numbers.size() == 1) {
                alternatedSum = numbers.get(0);
            }
            else {
                for (int i = 0; i < numbers.size(); i++) {
                    if (i % 2 == 0) {
                        alternatedSum += numbers.get(i);
                    }
                    else {
                        alternatedSum -= numbers.get(i);
                    }
                }
            }
            System.out.println("Alternated Sum: " + alternatedSum);
        }


    }
}
