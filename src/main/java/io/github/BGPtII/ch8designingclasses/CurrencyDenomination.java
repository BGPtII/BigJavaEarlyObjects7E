package io.github.BGPtII.ch8designingclasses;

public class CurrencyDenomination {

    private String name;
    private double value;

    public CurrencyDenomination(String name, double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("value cannot be less than or equal to 0.");
        }
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
