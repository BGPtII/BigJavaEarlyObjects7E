package io.github.BGPtII.ch6loops;

/**
 * A factor is a number that divides a given number without any remainder (e.g., for 10, factors are 1, 2, 5, and 10).
 */
public class FactorGenerator {
    private final int numberToFactor;
    private int lastAttemptedNumber;

    /**
     * Constructs a FactorGenerator object with the specified number to factor.
     * @param numberToFactor the number to factor
     */
    public FactorGenerator(int numberToFactor) {
        if (numberToFactor < 1) {
            throw new IllegalArgumentException("Number to factor must be greater than 0");
        }
        this.numberToFactor = numberToFactor;
        this.lastAttemptedNumber = 1;
    }

    /**
     * Returns the next factor of the number to factor.
     * @return the next factor
     */
    public int nextFactor() {
        while (numberToFactor % lastAttemptedNumber != 0) {
            lastAttemptedNumber++;
        }
        return lastAttemptedNumber++;
    }

    /**
     * Checks if there are more factors to generate.
     * @return true if there are more factors; false otherwise
     */
    public boolean hasMoreFactors() {
        return lastAttemptedNumber <= numberToFactor;
    }
}
