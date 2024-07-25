package io.github.BGPtII.ch9inheritance.circuit;

public class ResonantCircuit {

    private double resonantFrequency;
    private double bandWidth;
    private double gainAtResonantFrequency;

    public ResonantCircuit(double resonantFrequency, double bandWidth, double gainAtResonantFrequency) {
        this.resonantFrequency = resonantFrequency;
        this.bandWidth = bandWidth;
        this.gainAtResonantFrequency = gainAtResonantFrequency;
    }

    public double getResonantFrequency() {
        return resonantFrequency;
    }

    public void setResonantFrequency(double resonantFrequency) {
        this.resonantFrequency = resonantFrequency;
    }

    public double getBandWidth() {
        return bandWidth;
    }

    public void setBandWidth(double bandWidth) {
        this.bandWidth = bandWidth;
    }

    public double getGainAtResonantFrequency() {
        return gainAtResonantFrequency;
    }

    public void setGainAtResonantFrequency(double gainAtResonantFrequency) {
        this.gainAtResonantFrequency = gainAtResonantFrequency;
    }

    public String getDescription() {
        return String.format("""
                Resonant frequency response:
                Resonant frequency (ωo): %.2f rad/s
                Bandwidth (B): %.2f
                Gain at resonant frequency (k): %.2f
                """, resonantFrequency, bandWidth, gainAtResonantFrequency);
    }
}
