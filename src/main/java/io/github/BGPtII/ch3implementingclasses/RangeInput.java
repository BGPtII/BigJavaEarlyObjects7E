package io.github.BGPtII.ch3implementingclasses;

public class RangeInput {
    private int upperLimit;
    private int bottomLimit;
    private int currentValue;

    public RangeInput(int upperLimit, int bottomLimit) {
        this.upperLimit = upperLimit;
        this.bottomLimit = bottomLimit;
        this.currentValue = (upperLimit + bottomLimit) / 2;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public int getBottomLimit() {
        return bottomLimit;
    }

    public void setBottomLimit(int bottomLimit) {
        this.bottomLimit = bottomLimit;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public void up() {
        currentValue = Math.max(currentValue - 1, bottomLimit);
    }

    public void down() {
        currentValue = Math.min(currentValue + 1, upperLimit);
    }
}
