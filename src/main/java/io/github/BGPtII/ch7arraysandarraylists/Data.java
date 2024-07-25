package io.github.BGPtII.ch7arraysandarraylists;

public class Data {

    private double[] values;
    private double valuesSize;

    public Data(double[] values) {
        this.values = values;
        this.valuesSize = values.length;
    }

    /**
     * For every value, replacing it with the average of that value & its neighbours. Does not take into account
     * previously modified values when smoothing new value.
     */
    public void smooth() {
        if (values.length < 2) {
            return;
        }
        double previousValue = values[0];
        values[0] = (values[0] + values[1]) / 2.0;
        for (int i = 1; i < values.length - 1; i++) {
            double currentValue = values[i];
            values[i] = (previousValue + values[i] + values[i + 1]) / 3.0;
            previousValue = currentValue;
        }
        values[values.length - 1] = (previousValue + values[values.length - 1]) / 2.0;
    }
}
