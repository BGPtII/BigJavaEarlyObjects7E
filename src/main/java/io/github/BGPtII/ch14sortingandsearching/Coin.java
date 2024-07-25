package io.github.BGPtII.ch14sortingandsearching;

public class Coin implements Comparable<Coin> {

    private double value;


    public Coin(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public int compareTo(Coin o) {
        return Double.compare(value, o.getValue());
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
