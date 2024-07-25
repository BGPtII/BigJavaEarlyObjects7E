package io.github.BGPtII.ch6loops;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class IntegerSequenceInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> userInts = new ArrayList<>();

        while (true) {
            System.out.print("Enter an integer (\"done\" to display integer data): ");
            if (scanner.hasNext("done")) {
                break;
            }
            else if (scanner.hasNextInt()) {
                userInts.add(scanner.nextInt());
            }
            else {
                System.out.println("Only integers accepted!");
                scanner.next();
            }
        }

        if (userInts.isEmpty()) {
            System.out.println("No integers entered, therefore no data available.");
            return;
        }

        int smallestInt = Integer.MAX_VALUE;
        int largestInt = Integer.MIN_VALUE;
        int evenCount = 0;
        int oddCount = 0;
        int cumulativeTotal = 0;
        ArrayList<Integer> cumulativeTotals = new ArrayList<>();
        HashSet<Integer> adjacentDuplicates = new HashSet<>();
        int previousInt = userInts.get(0);

        for (int currentInt : userInts) {
            largestInt = Math.max(largestInt, currentInt);
            smallestInt = Math.min(smallestInt, currentInt);

            if (currentInt % 2 == 0) {
                evenCount++;
            }
            else {
                oddCount++;
            }

            cumulativeTotal += currentInt;
            cumulativeTotals.add(cumulativeTotal);

            if (currentInt == previousInt) {
                adjacentDuplicates.add(currentInt);
            }

            previousInt = currentInt;
        }

        System.out.println("Integer Data: " + userInts);
        System.out.println("Largest Integer: " + largestInt);
        System.out.println("Smallest Integer: " + smallestInt);
        System.out.println("Total even numbers: " + evenCount);
        System.out.println("Total odd numbers: " + oddCount);
        System.out.println("Cumulative totals: " + cumulativeTotals);
        System.out.println("Adjacent duplicates: " + adjacentDuplicates);
    }
}
