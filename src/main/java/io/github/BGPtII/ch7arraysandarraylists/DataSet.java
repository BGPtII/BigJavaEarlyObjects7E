package io.github.BGPtII.ch7arraysandarraylists;

public class DataSet {

    private double[] data;
    private int size;

    public DataSet(int maximumNumberOfValues) {
        data = new double[maximumNumberOfValues];
        size = 0;
    }

    public void add(int value) {
        if (size < data.length) {
            data[size] = value;
            size++;
        }
        else {
            System.out.println("Dataset is full, cannot add new values.");
        }
    }

    public double sum() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += data[i];
        }
        return sum;
    }

    public double average() {
        if (size == 0) {
            return 0;
        }
        return sum() / size;
    }

    public double minimum() {
        if (size == 0) {
            return Double.NaN;
        }
        double min = data[0];
        for (int i = 1; i < size; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }

    public double maximum() {
        if (size == 0) {
            return Double.NaN;
        }
        double max = data[0];
        for (int i = 1; i < size; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

}
