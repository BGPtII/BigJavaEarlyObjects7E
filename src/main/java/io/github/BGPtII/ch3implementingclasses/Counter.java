package io.github.BGPtII.ch3implementingclasses;

/**
 * Simulates a counter, starts at 0
 * Can be incremented or decremented
 */
public class Counter {
    private int value;
    private int maximum;

    /**
     * Constructs a Counter object
     * value is started at 0
     * maximum default is the max value of an integer
     */
    public Counter() {
        value = 0;
        maximum = Integer.MAX_VALUE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public void click() {
        if (value + 1 <= maximum) {
            value++;
        }
    }

    public void undo() {
        if (value - 1 >= 0) {
            value--;
        }
    }

}
