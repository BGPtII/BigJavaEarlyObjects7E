package io.github.BGPtII.ch14sortingandsearching;

import io.github.BGPtII.ch14sortingandsearching.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class ShellSort {

    public static void insertionSort(int[] a, int k, int c) {
        for (int i = k + c; i < a.length; i = i + c) {
            int next = a[i];
            // Move the larger elements up
            int j = i;
            while (j >= c && a[j - c] > next) {
                a[j] = a[j - c];
                j = j - c;
            }
            // Insert the next element
            a[j] = next;
        }
    }

    public static void shellSort(int[] a) {
        ArrayList<Integer> columns = new ArrayList<>();
        int c = 1;
        while (c < a.length) {
            columns.add(c);
            c = 3 * c + 1;
        }
        for (int s = columns.size() - 1; s >= 0; s--) {
            c = columns.get(s);
            for (int k = 0; k < c; k++) {
                insertionSort(a, k, c);
            }
        }
    }

    // For testing purposes
    public static void main(String[] args) {
        int[] a = ArrayUtil.randomIntArray(10, 100);
        System.out.println("randomIntArray(10, 100): " + Arrays.toString(a));
        shellSort(a);
        System.out.println("After shellSort: " + Arrays.toString(a));
    }
}
