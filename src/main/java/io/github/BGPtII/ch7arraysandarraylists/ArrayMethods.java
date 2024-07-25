package io.github.BGPtII.ch7arraysandarraylists;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayMethods {

    private int[] values;

    public ArrayMethods(int[] initialValues) {
        values = initialValues;
    }

    public int[] getValues() {
        return values;
    }

    public void swapFirstAndLast() {
        if (values.length > 1) {
            int first = values[0];
            values[0] = values[values.length - 1];
            values[values.length - 1] = first;
        }
    }

    /**
     * Shifts the last value to the beginning
     */
    public void shiftRight() {
        if (values.length <= 1) {
            return;
        }
        int lastValue = values[values.length - 1];
        for (int i = values.length - 1; i > 0; i--) {
            values[i] = values[i - 1];
        }
        values[0] = lastValue;
    }

    public void replaceAllEvenWithZero() {
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                values[i] = 0;
            }
        }
    }

    /**
     * Does not include the first and last elements, does not take into the account if the neighbouring values are
     * larger than the current index value (just compares the neighbouring values)
     */
    public void replaceValuesWithLargerNeighbouringValue() {
        if (values.length < 3) {
            return;
        }
        int[] newValues = Arrays.copyOf(values, values.length);
        for (int i = 1; i < values.length - 1; i ++) {
            newValues[i] = Math.max(values[i - 1], values[i + 1]);
        }
        values = newValues;
    }

    public void removeMiddle() {
        if (values.length < 3) {
            return;
        }
        int middleIndex = values.length / 2;
        if (values.length % 2 == 0) {
            for (int i = middleIndex - 1; i < values.length - 2; i++) {
                values[i] = values[i + 2];
            }
            values = Arrays.copyOf(values, values.length - 2);
        }
        else {
            for (int i = middleIndex; i < values.length - 1; i++) {
                values[i] = values[i + 1];
            }
            values = Arrays.copyOf(values, values.length - 1);
        }
    }

    /**
     * Preserves the order of the odd and even numbers; by front it is the leftmost side/beginning of the array
     */
    public void moveEvenValuesToFront() {
        if (values.length <= 1) {
            return;
        }
        int insertionIndex = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                int temp = values[i];
                for (int j = i; j > insertionIndex; j--) {
                    values[j] = values[j - 1];
                }
                values[insertionIndex] = temp;
                insertionIndex++;
            }
        }
    }

    public boolean isSortedInIncreasingOrder() {
        for (int i = 1; i < values.length; i ++) {
            if (values[i - 1] > values[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Must be only 2 same adjacent, not 3+ in order to return true
     */
    public boolean containsTwoSameAdjacentValues() {
        for (int i = 0; i < values.length - 1; i++) {
            if ((values[i] == values[i + 1])
                    && (i == 0 || values[i - 1] != values[i])
                    && (i + 2 == values.length || values[i + 2] != values[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicateValues() {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int value : values) {
            if (!hashSet.add(value)) {
                return true;
            }
        }
        return false;
    }

}
