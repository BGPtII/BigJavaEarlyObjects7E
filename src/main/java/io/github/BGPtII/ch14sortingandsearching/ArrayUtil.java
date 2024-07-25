package io.github.BGPtII.ch14sortingandsearching;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtil {

    private static Random generator = new Random();

    /**
     * Creates an integer array filled with random values
     * @param length the length of the array
     * @param n the number of possible random values
     * @return an integer array filled with length numbers between 0 and n - 1
     */
    public static int[] randomIntArray(int length, int n) {
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = generator.nextInt(n);
        }
        return a;
    }

    /**
     * Creates a coin array filled with random values
     * @param length the length of the array
     * @param n the number of possible random values
     * @return a coin array filled with length numbers between 0 and n - 1
     */
    public static Coin[] randomCoinArray(int length, double n) {
        Coin[] coins = new Coin[length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = new Coin(generator.nextDouble(n));
        }
        return coins;
    }

    /**
     * Sorts an array of integers in ascending order using the selection sort algorithm
     * @param a the integer array to sort
     */
    public static void intArraySelectionSortAscending(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minPos = minimumPosition(a, i);
            intArrayPosSwap(a, minPos, i);
        }
    }

    public static void coinArraySelectionSortAscending(Coin[] coins) {
        for (int i = 0; i < coins.length; i++) {
            int minPos = minimumPositionCoins(coins, i);
            coinsArrayPosSwap(coins, minPos, i);
        }
    }

    public static void objectSelectionSortAscending(Comparable[] objects) {
        for (int i = 0; i < objects.length; i++) {
            int minPos = minimumPositionObjects(objects, i);
            objectsArrayPosSwap(objects, minPos, i);
        }
    }

    /**
     * Sorts an array of integers in descending order using the selection sort algorithm
     * @param a the integer array to sort
     */
    public static void intArraySelectionSortDescending(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int maxPos = maximumPosition(a, i);
            intArrayPosSwap(a, maxPos, i);
        }
    }

    /**
     * Sorts an array using the merge sort algorithm in ascending order
     * @param a the integer array to sort
     */
    public static void intArrayMergeSort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        int[] first = new int[a.length / 2];
        int[] second = new int[a.length - first.length];
        for (int i = 0; i < first.length; i++) {
            first[i] = a[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = a[first.length + i];
        }
        intArrayMergeSort(first);
        intArrayMergeSort(second);
        intArrayMerge(first, second, a);
    }

    /**
     * Sorts the string array in lexicographic order
     * @param strings the string array to sort
     */
    public static void stringArrayMergeSort(String[] strings) {
        if (strings.length <= 1) {
            return;
        }
        String[] first = new String[strings.length / 2];
        String[] second = new String[strings.length - first.length];
        for (int i = 0; i < first.length; i++) {
            first[i] = strings[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = strings[first.length + i];
        }
        stringArrayMergeSort(first);
        stringArrayMergeSort(second);
        stringArrayMerge(first, second, strings);
    }

    public static void intArrayInsertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int next = a[i];
            // Move larger elements up
            int j = i;
            while (j > 0 && a[j - 1] > next) {
                a[j] = a[j - 1];
                j--;
            }
            // Insert the next element
            a[j] = next;
        }
    }

    /**
     * Sorts an array of integers in ascending order using the bubble sort algorithm
     * @param a the array of integers to sort
     */
    public static void intArrayBubbleSort(int[] a) {
        int temp;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (a[j - 1] > a[j]) {
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * Finds a value in a range of a sorted array, using the binary search algorithm
     * @param a the sorted integer array to search
     * @param low the low index of the range
     * @param high the high index of the range
     * @param value the value to find
     * @return the index at which the value occurs, or -k - 1, where k is the index where it should be inserted so the
     * ascending order of the array is still maintained.
     */
    public static int intArrayBinarySearch(int[] a, int low, int high, int value) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            }
            else if (a[mid] < value) {
                return intArrayBinarySearch(a, mid + 1, high, value);
            }
            else {
                return intArrayBinarySearch(a, low, mid - 1, value);
            }
        }
        else {
            return -low - 1;
        }
    }

    /**
     * Finds the smallest element in a tail range of the array
     * @param a the integer array to sort
     * @param from the first position in the array to compare
     * @return the position of the smallest element in the range a[from] to a[a.length - 1]
     */
    private static int minimumPosition(int[] a, int from) {
        int minPos = from;
        for (int i = from + 1; i < a.length; i++) {
            if (a[i] < a[minPos]) {
                minPos = i;
            }
        }
        return minPos;
    }

    private static int minimumPositionCoins(Coin[] coins, int from) {
        int minPos = from;
        for (int i = from + 1; i < coins.length; i++) {
            if (coins[i].getValue() < coins[minPos].getValue()) {
                minPos = i;
            }
        }
        return minPos;
    }

    private static int minimumPositionObjects(Comparable[] objects, int from) {
        int minPos = from;
        for (int i = from + 1; i < objects.length; i++) {
            if (objects[i].compareTo(objects[minPos]) < 0) {
                minPos = i;
            }
        }
        return minPos;
    }

    private static int maximumPosition(int[] a, int from) {
        int maxPos = from;
        for (int i = from + 1; i < a.length; i++) {
            if (a[i] > a[maxPos]) {
                maxPos = i;
            }
        }
        return maxPos;
    }

    /**
     *
     * @param a the integer array
     * @param i the first position to swap
     * @param j the second position to swap
     */
    private static void intArrayPosSwap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void coinsArrayPosSwap(Coin[] coins, int i, int j) {
        Coin temp = coins[i];
        coins[i] = coins[j];
        coins[j] = temp;
    }

    private static void objectsArrayPosSwap(Object[] objects, int i, int j) {
        Object temp = objects[i];
        objects[i] = objects[j];
        objects[j] = temp;
    }

    /**
     * Merges 2 sorted integer arrays into an array
     * @param first the first sorted array
     * @param second the second sorted array
     * @param a the array into which to merge first and second
     */
    private static void intArrayMerge(int[] first, int[] second, int[] a) {
        int iFirst = 0; // Next element to consider in the first array
        int iSecond = 0; // Next element to consider in the second array
        int j = 0; // Next open position in a

        // As long as neither iFirst not iSecond past the end, move the smaller element into a
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                a[j] = first[iFirst];
                iFirst++;
            }
            else {
                a[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }

        // Copy any remaining entries of the first array
        while (iFirst < first.length) {
            a[j] = first[iFirst];
            iFirst++;
            j++;
        }
        //Copy any remaining entries of the second array
        while (iSecond < second.length) {
            a[j] = second[iSecond];
            iSecond++;
            j++;
        }
    }

    private static void stringArrayMerge(String[] first, String[] second, String[] strings) {
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].compareTo(second[iSecond]) < 0) {
                strings[j] = first[iFirst];
                iFirst++;
            }
            else {
                strings[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        while (iFirst < first.length) {
            strings[j] = first[iFirst];
            iFirst++;
            j++;
        }
        while (iSecond < second.length) {
            strings[j] = second[iSecond];
            iSecond++;
            j++;
        }
    }

    // For testing purposes
    public static void main(String[] args) {
        int[] a = randomIntArray(10, 100);
        System.out.println("randomIntArray(10, 100): " + Arrays.toString(a));
        intArraySelectionSortAscending(a);
        System.out.println("After selectionSortAscending: " + Arrays.toString(a));
        intArraySelectionSortDescending(a);
        System.out.println("After selectionSortDescending: " + Arrays.toString(a));
        System.out.println();

        Coin[] coins = randomCoinArray(15, 100);
        System.out.println("randomCoinArray(10, 100): " + Arrays.toString(coins));
        coinArraySelectionSortAscending(coins);
        System.out.println("After coinArraySelectionSortAscending: " + Arrays.toString(coins));
        System.out.println();

        a = randomIntArray(15, 100);
        System.out.println("randomIntArray(15, 100): " + Arrays.toString(a));
        intArrayMergeSort(a);
        System.out.println("After mergeSort: " + Arrays.toString(a));
        System.out.println();

        String[] strings = new String[] { "Butterfly", "Applesauce", "Boat", "Zebra", "Garlic", "Flower", "Xylophone" };
        System.out.println("strings1: " + Arrays.toString(strings));
        stringArrayMergeSort(strings);
        System.out.println("After stringArrayMergeSort: " + Arrays.toString(strings));
        System.out.println();

        a = randomIntArray(10, 100);
        System.out.println("randomIntArray(10, 100): " + Arrays.toString(a));
        intArrayInsertionSort(a);
        System.out.println("After intArrayInsertionSort: " + Arrays.toString(a));
        System.out.println();

        a = randomIntArray(10, 100);
        System.out.println("randomIntArray(10, 100): " + Arrays.toString(a));
        intArrayBubbleSort(a);
        System.out.println("After intArrayBubbleSort: " + Arrays.toString(a));
        System.out.println("Result of intArrayBinarySearch for value 12: " + intArrayBinarySearch(a, 0, 10, 12));
    }

}
