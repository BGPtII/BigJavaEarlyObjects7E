package io.github.BGPtII.ch7arraysandarraylists;

import java.util.Scanner;

/**
 * Reads an integer for a number of stalls, finds the best case scenario for male preference when choosing a stall;
 * maximizes at a reasonable number of 50.
 * Prints the diagram at every person's occupation until there's no available spaces within the criteria left.
 * Follows the pattern of: males choosing the middle of the longest sequence of vacant stalls, continuing until there
 * is either 1 or 2 vacant spaces between each stall.
 */
public class OptimalStallSpace {

    public static int[] findLongestFalseSegmentIndexes(boolean[] boolArray) {
        int[] longestFalseSegmentIndexes = new int[2];
        int segmentStartIndex = 0;
        int segmentEndIndex;
        boolean isInSegment = false;
        for (int i = 0; i < boolArray.length; i++) {
            if (!boolArray[i] && !isInSegment) {
                segmentStartIndex = i;
                isInSegment = true;
            }
            if (isInSegment && (boolArray[i] || (!boolArray[i] && i == boolArray.length - 1))) {
                segmentEndIndex = (!boolArray[i] && i == boolArray.length - 1) ? i : i - 1;
                isInSegment = false;
                if (segmentEndIndex - segmentStartIndex > longestFalseSegmentIndexes[1] - longestFalseSegmentIndexes[0]) {
                    longestFalseSegmentIndexes[0] = segmentStartIndex;
                    longestFalseSegmentIndexes[1] = segmentEndIndex;
                }
            }
        }
        return longestFalseSegmentIndexes;
    }

    public static void printBoolArrayDiagram(boolean[] boolArray) {
        for (boolean bool : boolArray) {
            if (bool) {
                System.out.print("X");
            }
            else {
                System.out.print("_");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of stalls in a line (between 1 & 50 - inclusive): ");
        if (scanner.hasNextInt()) {
            int totalStalls = scanner.nextInt();
            if (totalStalls > 0 && totalStalls < 51) {
                boolean[] occupiedStallDiagram = new boolean[totalStalls];
                boolean areVacantStallsLeft = true;
                while (areVacantStallsLeft) {
                    int[] longestSegmentIndexes = findLongestFalseSegmentIndexes(occupiedStallDiagram);
                    int length = longestSegmentIndexes[1] - longestSegmentIndexes[0] + 1;
                    if (length <= 2) {
                        if (occupiedStallDiagram.length < 3 && !occupiedStallDiagram[0]) {
                            occupiedStallDiagram[0] = true;
                            printBoolArrayDiagram(occupiedStallDiagram);
                        }
                        if (occupiedStallDiagram.length > 2) {
                            if (!occupiedStallDiagram[0] && !occupiedStallDiagram[1]) {
                                occupiedStallDiagram[0] = true;
                                printBoolArrayDiagram(occupiedStallDiagram);
                            }
                            if (!occupiedStallDiagram[occupiedStallDiagram.length - 1] && !occupiedStallDiagram[occupiedStallDiagram.length - 2]) {
                                occupiedStallDiagram[occupiedStallDiagram.length - 1] = true;
                                printBoolArrayDiagram(occupiedStallDiagram);
                            }
                        }
                        areVacantStallsLeft = false;
                    }
                    else {
                        occupiedStallDiagram[(longestSegmentIndexes[0] + longestSegmentIndexes[1]) / 2] = true;
                        printBoolArrayDiagram(occupiedStallDiagram);
                    }
                }
            }
            else {
                System.out.println("Invalid input, numbers between 1 & 50 (inclusive) accepted.");
            }
        }
        else {
            System.out.println("Invalid input, only integers accepted.");
        }
        scanner.close();
    }

}
