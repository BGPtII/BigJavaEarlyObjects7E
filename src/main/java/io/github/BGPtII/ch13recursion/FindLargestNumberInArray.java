package io.github.BGPtII.ch13recursion;

public class FindLargestNumberInArray {

    public static double getLargestNumber(double[] doubles) {
        if (doubles.length == 1) {
            return doubles[0];
        }
        return getLargestNumberHelper(doubles, 0, doubles[0]);
    }

    public static int getLargestNumber(int[] ints) {
        if (ints.length == 1) {
            return ints[0];
        }
        return getLargestNumberHelper(ints, 0, ints[0]);
    }

    private static double getLargestNumberHelper(double[] doubles, int index, double largestNumber) {
        if (index == doubles.length) {
            return largestNumber;
        }
        if (doubles[index] > largestNumber) {
            largestNumber = doubles[index];
        }
        return getLargestNumberHelper(doubles, index + 1, largestNumber);
    }

    private static int getLargestNumberHelper(int[] ints, int index, int largestNumber) {
        if (index == ints.length) {
            return largestNumber;
        }
        if (ints[index] > largestNumber) {
            largestNumber = ints[index];
        }
        return getLargestNumberHelper(ints, index + 1, largestNumber);
    }

    public static void main(String[] args) {
        int[] ints1 = new int[] { 1, 5, -12, 3, 4, 10 };
        System.out.println("ints1 expected: 10, actual: " + getLargestNumber(ints1));
        int[] ints2 = new int[] { -1, -5, -12, -3, -4, -10 };
        System.out.println("ints1 expected: -1, actual: " + getLargestNumber(ints2));
        double[] doubles1 = new double[] { 10.2, -4.3, 11, -4, 10.3 };
        System.out.println("doubles1 expected: 11.0, actual: " + getLargestNumber(doubles1));
    }

}
