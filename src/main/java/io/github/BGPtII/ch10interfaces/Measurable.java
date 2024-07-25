package io.github.BGPtII.ch10interfaces;

public interface Measurable {

    double getMeasure();

    static double average(Measurable[] measurables) {
        double sum = 0;
        for (Measurable measurable : measurables) {
            sum += measurable.getMeasure();
        }
        return sum / measurables.length;
    }

    static Measurable larger(Measurable measurable1, Measurable measurable2) {
        return (measurable1.getMeasure() > measurable2.getMeasure()) ? measurable1 : measurable2;
    }

    static Measurable largest(Measurable[] measurables) {
        if (measurables.length == 0) {
            throw new IllegalArgumentException("Array can't be empty.");
        }
        int largestIndex = 0;
        for (int i = 1; i < measurables.length; i++) {
            if (measurables[i].getMeasure() > measurables[largestIndex].getMeasure()) {
                largestIndex = i;
            }
        }
        return measurables[largestIndex];
    }

    static Measurable smallest(Measurable[] measurables) {
        if (measurables.length == 0) {
            throw new IllegalArgumentException("Array can't be empty.");
        }
        int smallestIndex = 0;
        for (int i = 1; i < measurables.length; i++) {
            if (measurables[i].getMeasure() < measurables[smallestIndex].getMeasure()) {
                smallestIndex = i;
            }
        }
        return measurables[smallestIndex];
    }
}
