package io.github.BGPtII.ch14sortingandsearching;

import java.util.Scanner;

/**
 * Can take a while to process performance metrics depending on array length & the amount of times
 * the amount doubles
 */
public class InsertionSortPerformanceMetric {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StopWatch sW = new StopWatch();
        Boolean doubleTheArray = null;
        int numberOfDoubles = -1;
        int initialArrayLength = -1;
        int maximumRandomValue = -1;

        System.out.println("Performance Metrics of the Insertion Sort Algorithm (\"q\" to Quit)");
        System.out.println("Uses randomly generated integer arrays.");
        while (true) {
            if (doubleTheArray == null) {
                System.out.print("Should the array double a set amount of times? (y/n): ");
                String line = scanner.nextLine().trim().toLowerCase();
                if (line.equals("q")) {
                    System.out.println("Quiting...");
                    break;
                }
                else if (line.equals("y") || line.equals("n")) {
                    doubleTheArray = line.equals("y");
                }
                else {
                    System.out.println("Only \"y\" or \"n\" are valid.");
                }
            }
            else if (doubleTheArray && numberOfDoubles < 1) {
                System.out.print("How many times should the length double? ");
                String line = scanner.nextLine().trim();
                if (line.equals("q")) {
                    System.out.println("Quitting...");
                    break;
                }
                else {
                    try {
                        int lineAmount = Integer.parseInt(line);
                        if (lineAmount < 1) {
                            System.out.println("The amount of length double iterations must be greater than 0.");
                        }
                        else {
                            numberOfDoubles = lineAmount;
                        }
                    }
                    catch (NumberFormatException e) {
                        System.out.println("The amount of length double iterations must be a valid integer.");
                    }
                }
            }
            else if (initialArrayLength < 1) {
                System.out.print("Enter the length of the array: ");
                String line = scanner.nextLine().trim();
                if (line.equals("q")) {
                    System.out.println("Quitting...");
                    break;
                }
                else {
                    try {
                        int lineAmount = Integer.parseInt(line);
                        if (lineAmount < 1) {
                            System.out.println("The length of the array must be greater than 0.");
                        }
                        else {
                            initialArrayLength = lineAmount;
                        }
                    }
                    catch (NumberFormatException e) {
                        System.out.println("The length of the array must be a valid integer.");
                    }
                }
            }
            else if (maximumRandomValue < 1) {
                System.out.print("Enter the maximum value of each randomly generated element: ");
                String line = scanner.nextLine().trim();
                if (line.equals("q")) {
                    System.out.println("Quitting...");
                    break;
                }
                else {
                    try {
                        int lineAmount = Integer.parseInt(line);
                        if (lineAmount < 1) {
                            System.out.println("The element value maximum must be greater than 0.");
                        }
                        else {
                            maximumRandomValue = lineAmount;
                        }
                    }
                    catch (NumberFormatException e) {
                        System.out.println("The element value maximum must be a valid integer.");
                    }
                }
            }
            else {
                int[] a;
                System.out.println("Should double: " + doubleTheArray);
                if (doubleTheArray) {
                    System.out.println("Amount of double iterations: " + numberOfDoubles);
                }
                System.out.println("Initial array length: " + initialArrayLength);
                System.out.println("Max element value: " + maximumRandomValue);
                if (doubleTheArray) {
                    for (int i = 0; i < numberOfDoubles; i++) {
                        a = ArrayUtil.randomIntArray(initialArrayLength, maximumRandomValue);
                        System.out.println("Iteration number: " + (i + 1));
                        System.out.println("Current array length: " + initialArrayLength);
                        sW.start();
                        ArrayUtil.intArrayInsertionSort(a);
                        sW.stop();
                        System.out.println("Performance metrics in ms: " + sW.getElapsedTime() + ".");
                        sW.reset();
                        initialArrayLength *= 2;
                    }
                }
                else {
                    a = ArrayUtil.randomIntArray(initialArrayLength, maximumRandomValue);
                    sW.start();
                    ArrayUtil.intArrayInsertionSort(a);
                    sW.stop();
                    System.out.println("Time in ms for the insertion sort algorithm to process int[] of length " + initialArrayLength);
                    System.out.println("with a maximum random element value of " + maximumRandomValue + " is " + sW.getElapsedTime() + ".");
                }
                break;
            }
        }
        scanner.close();
    }

}
