package io.github.BGPtII.ch7arraysandarraylists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Sequence {

    private int[] values;

    public Sequence(int size) {
        values = new int[size];
    }


    /**
     * Helper method for counting the non-zero values of this & other Sequence
     */
    private int countNonZeroValues(Sequence other) {
        int nonZeroValueCount = 0;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) != 0) {
                nonZeroValueCount++;
            }
        }
        for (int j = 0; j < other.size(); j++) {
            if (other.get(j) != 0) {
                nonZeroValueCount++;
            }
        }
        return nonZeroValueCount;
    }

    public void set(int index, int wholeNumber) {
        if (index >= 0 && index < values.length) {
            values[index] = wholeNumber;
        }
    }

    public int get(int index) {
        return values[index];
    }

    public int size() {
        return values.length;
    }

    /**
     * Returns whether this sequence & the other sequence contain the same values in the same order
     */
    public boolean equals(Sequence other) {
        if (values.length != other.size()) {
            return false;
        }
        for (int i = 0; i < other.size(); i++) {
            if (this.get(i) != other.get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Does not take into account duplicates for equality check
     */
    public boolean sameValues(Sequence other) {
        HashSet<Integer> uniqueValues = new HashSet<>();
        for (int value : values) {
            uniqueValues.add(value);
        }
        for (int value : other.values) {
            if (!uniqueValues.contains(value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Takes duplicates into account for equality check
     */
    public boolean isPermutationOf(Sequence other) {
        if (this.size() != other.size()) {
            return false;
        }
        HashMap<Integer, Integer> freqMapThis = new HashMap<>();
        for (int value : values) {
            freqMapThis.put(value, freqMapThis.getOrDefault(value, 0) + 1);
        }
        HashMap<Integer, Integer> freqMapOther = new HashMap<>();
        for (int value : other.values) {
            freqMapOther.put(value, freqMapOther.getOrDefault(value, 0) + 1);
        }
        return freqMapThis.equals(freqMapOther);
    }

    public Sequence sum(Sequence other) {
        int maxLength = Math.max(this.size(), other.size());
        Sequence result = new Sequence(maxLength);
        for (int i = 0; i < maxLength; i++) {
            int sum = (i < this.size() ? this.get(i) : 0) + (i < other.size() ? other.get(i) : 0);
            result.set(i, sum);
        }
        return result;
    }

    /**
     * Creates a new sequence adding all the values from this & the other sequence - includes the 0 values
     */
    public Sequence append(Sequence other) {
        Sequence appended = new Sequence(this.size() + other.size());
        for (int i = 0; i < this.size(); i++) {
            appended.set(i, this.get(i));
        }
        for (int j = 0; j < other.size(); j++) {
            appended.set(this.size() + j, other.get(j));
        }
        return appended;
    }

    /**
     * Merges two sequences, and alternates the elements from both, starting at this sequence.
     * Does not include elements containing 0.
     */
    public Sequence merge(Sequence other) {
        int nonZeroValueCount = countNonZeroValues(other);
        Sequence merged = new Sequence(nonZeroValueCount);
        int mergedIndex = 0;
        for (int i = 0; i <= Math.max(this.size(), other.size()); i++) {
            if (i < this.size() && this.get(i) != 0) {
                merged.set(mergedIndex, this.get(i));
                mergedIndex++;
            }
            if (i < other.size() && other.get(i) != 0) {
                merged.set(mergedIndex, other.get(i));
                mergedIndex++;
            }
        }
        return merged;
    }

    /**
     * Merges this & other Sequence in ascending order, ignoring the 0 values, doesn't ignore duplicates
     */
    public Sequence mergeSorted(Sequence other) {
        int[] mergedArray = new int[this.size() + other.size()];
        int index = 0;
        for (int i = 0; i < this.size(); i++) {
            int value = this.get(i);
            if (value != 0) {
                mergedArray[index++] = value;
            }
        }
        for (int j = 0; j < other.size(); j++) {
            int value = other.get(j);
            if (value != 0) {
                mergedArray[index++] = value;
            }
        }
        Arrays.sort(mergedArray);
        Sequence mergeSorted = new Sequence(index);
        for (int i = 0; i < index; i++) {
            mergeSorted.set(i, mergedArray[i]);
        }
        return mergeSorted;
    }
}
