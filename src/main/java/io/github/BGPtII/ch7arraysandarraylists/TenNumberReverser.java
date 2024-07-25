package io.github.BGPtII.ch7arraysandarraylists;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A loop that reads ten numbers and a second loop that displays them in the
 * opposite order from which they were entered
 */
public class TenNumberReverser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<>();

        while (numbers.size() < 10) {
            System.out.print("Enter a number ('q' to quit): ");
            if (scanner.hasNext("q")) {
                System.out.println("Exiting...");
                System.exit(0);
            }
            else if (scanner.hasNextDouble()) {
                numbers.add(scanner.nextDouble());
            }
            else {
                System.out.println("Invalid scanner, numbers only.");
                scanner.next();
            }
        }
        scanner.close();

        for (int i = numbers.size() - 1; i >= 0; i--) {
            System.out.println(numbers.get(i));
        }
    }

}
