package io.github.BGPtII.ch8designingclasses;

public class VoltageDivider {

    private Resistor r1;
    private Resistor r2;

    private double nominalGain;
    private double actualGain;

    public VoltageDivider(Resistor r1, Resistor r2) {
        this.r1 = r1;
        this.r2 = r2;
        this.nominalGain = getGain(r1.getNominalResistance(), r2.getActualResistance());
        this.actualGain = getGain(r1.getActualResistance(), r2.getActualResistance());
    }

    private double getGain(double resistance1, double resistance2) {
        return resistance2 / (resistance1 + resistance2);
    }

    public double getNominalGain() {
        return nominalGain;
    }

    public double getActualGain() {
        return actualGain;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Resistor r1 = new Resistor(250, 5);
            Resistor r2 = new Resistor(750, 5);
            VoltageDivider voltageDivider = new VoltageDivider(r1, r2);
            System.out.println("Actual gain: " + voltageDivider.getActualGain());
            System.out.println("Nominal gain: " + voltageDivider.getNominalGain());
        }
    }

}
