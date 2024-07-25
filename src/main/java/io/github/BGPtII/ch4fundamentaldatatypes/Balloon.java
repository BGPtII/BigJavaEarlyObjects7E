package io.github.BGPtII.ch4fundamentaldatatypes;

/**
 * Spherical balloon
 * Volume is in cm^3
 */
public class Balloon {
    private double volume;

    public Balloon() {
        volume = 0;
    }

    public void addAir(double amount) {
        volume += amount;
    }

    public double getVolume() {
        return volume;
    }

    public double getSurfaceArea() {
        return 4 * Math.PI * Math.pow(getRadius(), 2);
    }

    public double getRadius() {
        return Math.pow((3 * volume) / (4 * Math.PI), 1 / 3.0);
    }
}
