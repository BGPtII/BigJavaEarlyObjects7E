package io.github.BGPtII.ch3implementingclasses;

public class RoachPopulation {
    private int population;

    public RoachPopulation(int initialPopulation) {
        population = initialPopulation;
    }

    public void breed() {
        population *= 2;
    }

    public void spray(int percentage) {
        population = (int) (population - Math.round(percentage / 100.0 * population));
    }

    public int getRoaches() {
        return population;
    }
}
