package io.github.BGPtII.ch6loops;

import java.util.ArrayList;
import java.util.Scanner;

public class DataSet {
    private ArrayList<Double> numbers;

    public DataSet() {
        numbers = new ArrayList<>();
    }

    public void add(double value) {
        numbers.add(value);
    }

    public double getSmallest() {
        if (numbers.isEmpty()) {
            return Double.NaN;
        }
        double smallest = Double.MAX_VALUE;
        for (double num : numbers) {
            if (num < smallest) {
                smallest = num;
            }
        }
        return smallest;
    }

    public double getLargest() {
        if (numbers.isEmpty()) {
            return Double.NaN;
        }
        double largest = Double.MIN_VALUE;
        for (double num : numbers) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }

    public double getAverage() {
        if (numbers.isEmpty()) {
            return Double.NaN;
        }
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum / numbers.size();
    }

    public double getRange() {
        if (numbers.isEmpty()) {
            return Double.NaN;
        }
        return getLargest() - getSmallest();
    }

    public static DataSet readDataSetFromUser() {
        Scanner scanner = new Scanner(System.in);
        DataSet dataSet = new DataSet();

        System.out.println("Enter numbers, type 'done' to finish:");

        while (true) {
            if (scanner.hasNext("done")) {
                break;
            } else if (scanner.hasNextDouble()) {
                double input = scanner.nextDouble();
                dataSet.add(input);
            } else {
                System.out.println("Invalid input. Enter a number or 'done'.");
                scanner.next();
            }
        }

        scanner.close();
        return dataSet;
    }

    public static void main(String[] args) {
        DataSet dataSet = readDataSetFromUser();

        if (!dataSet.numbers.isEmpty()) {
            System.out.println("User-entered numbers: " + dataSet.numbers.size());
            System.out.println("Average: " + dataSet.getAverage());
            System.out.println("Smallest: " + dataSet.getSmallest());
            System.out.println("Largest: " + dataSet.getLargest());
            System.out.println("Range: " + dataSet.getRange());
        }
        else {
            System.out.println("No numbers entered.");
        }
    }
}
