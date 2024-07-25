package io.github.BGPtII.ch8designingclasses;

import java.util.HashMap;
import java.util.Random;

public class Resistor {

    private double nominalResistance;
    private double tolerance;
    private Random randomGenerator;
    private double actualResistance;

    private static final HashMap<Double, String> TOLERANCE_TO_BAND_COLOUR = new HashMap<>() {
        {
            put(1.0, "Brown");
            put(2.0, "Red");
            put(0.5, "Green");
            put(0.25, "Blue");
            put(0.1, "Violet");
            put(0.05, "Gray");
            put(5.0, "Gold");
            put(10.0, "Silver");
        }
    };
    private static final HashMap<Integer, String> RESISTANCE_SIG_DIGIT_TO_BAND_COLOUR = new HashMap<>() {
        {
            put(0, "Black");
            put(1, "Brown");
            put(2, "Red");
            put(3, "Orange");
            put(4, "Yellow");
            put(5, "Green");
            put(6, "Blue");
            put(7, "Violet");
            put(8, "Gray");
            put(9, "White");
        }
    };
    private static final HashMap<Integer, String> MULTIPLIER_EXPONENT_TO_BAND_COLOUR = new HashMap<>() {
        {
            put(0, "Black");
            put(1, "Brown");
            put(2, "Red");
            put(3, "Orange");
            put(4, "Yellow");
            put(5, "Green");
            put(6, "Blue");
            put(7, "Violet");
            put(8, "Gray");
            put(9, "White");
            put(-1, "Gold");
            put(-2, "Silver");
        }
    };

    public Resistor(double nominalResistance, double tolerance) {
        if (nominalResistance < 0 || tolerance < 0) {
            throw new IllegalArgumentException("Values cannot be less than or equal to 0.");
        }
        this.nominalResistance = nominalResistance;
        this.tolerance = tolerance;
        this.randomGenerator = new Random();
        this.actualResistance = generateActualResistance();
    }

    public double getNominalResistance() {
        return nominalResistance;
    }

    public double getTolerance() {
        return tolerance;
    }

    public double getActualResistance() {
        return actualResistance;
    }

    private double generateActualResistance() {
        double minActual = nominalResistance * (1 - tolerance / 100);
        double maxActual = nominalResistance * (1 + tolerance / 100);
        return minActual + (maxActual - minActual) * randomGenerator.nextDouble();
    }

    public String getColorBandDescription() {
        int firstSigDigit = (int) (nominalResistance / Math.pow(10, Math.floor(Math.log10(nominalResistance))));
        int secondSigDigit = (int) ((nominalResistance / Math.pow(10, Math.floor(Math.log10(nominalResistance)) - 1)) % 10);
        int multiplierExponent = (int) Math.floor(Math.log10(nominalResistance));

        String firstBand = RESISTANCE_SIG_DIGIT_TO_BAND_COLOUR.getOrDefault(firstSigDigit, "None");
        String secondBand = RESISTANCE_SIG_DIGIT_TO_BAND_COLOUR.getOrDefault(secondSigDigit, "None");
        String multiplierBand = MULTIPLIER_EXPONENT_TO_BAND_COLOUR.getOrDefault(multiplierExponent, "None");
        String toleranceBand = TOLERANCE_TO_BAND_COLOUR.getOrDefault(tolerance, "None");

        return String.format("Resistance colour bands: %s, %s, %s.\nTolerance band: %s.", firstBand, secondBand, multiplierBand, toleranceBand);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Resistor resistor = new Resistor(330, 10);
            System.out.println("Actual resistance: " + resistor.actualResistance);
        }
    }
}
