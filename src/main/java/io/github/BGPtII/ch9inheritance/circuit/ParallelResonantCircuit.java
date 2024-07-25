package io.github.BGPtII.ch9inheritance.circuit;

public class ParallelResonantCircuit extends ResonantCircuit {

    private double resistance;
    private double inductance;
    private double capacitance;

    public ParallelResonantCircuit(double resonantFrequency, double bandWidth, double gainAtResonantFrequency) {
        super(resonantFrequency, bandWidth, gainAtResonantFrequency);
        this.resistance = getResonantFrequency();
        this.capacitance = 1 / (getBandWidth() * resistance);
        this.inductance = 1 / (Math.pow(getResonantFrequency(), 2) * capacitance);
    }

    @Override
    public String getDescription() {
        return String.format("""
                Parallel Resonant Circuit:
                Resistance (R): %.2f ohms
                Inductance (L): %.2f H
                Capacity (C): %.2e F
                """, resistance, inductance, capacitance);
    }

}
