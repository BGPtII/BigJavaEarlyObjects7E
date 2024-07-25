package io.github.BGPtII.ch10interfaces;

public class Coin implements Comparable<Coin> {

    private double value;

    public Coin(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public int compareTo(Coin coin) {
        return Double.compare(this.getValue(), coin.getValue());
    }
}
