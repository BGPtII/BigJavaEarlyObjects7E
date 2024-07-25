package io.github.BGPtII.ch9inheritance.circuit;

public class SeriesResonantCircuit extends ResonantCircuit {

    private double resistance;
    private double inductance;
    private double capacitance;

    public SeriesResonantCircuit(double resonantFrequency, double bandWidth, double gainAtResonantFrequency) {
        super(resonantFrequency, bandWidth, gainAtResonantFrequency);
        this.resistance =  1 / getResonantFrequency();
        this.inductance = resistance / getBandWidth();
        this.capacitance = 1 / (Math.pow(getResonantFrequency(), 2) * inductance);
    }

    @Override
    public String getDescription() {
        return String.format("""
                Series Resonant Circuit:
                Resistance (R): %.2f ohms
                Inductance (L): %.2f H
                Capacity (C): %.2e F
                """, resistance, inductance, capacitance);
    }

}
