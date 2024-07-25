package io.github.BGPtII.ch8designingclasses;

import java.util.Arrays;

public class ComboLock {

    private int[] combination;
    private int[] attemptNumbers;
    private int attemptNumbersPosition;
    private int dialNumber;

    public ComboLock(int[] combination) {
        if (combination.length != 3) {
            throw new IllegalArgumentException("Combination length can't be anything but 3.");
        }
        for (int number : combination) {
            if (number < 0 || number > 39) {
                throw new IllegalArgumentException("Integers in entrySequence must be between 0 & 39 inclusive.");
            }
        }
        this.combination = combination;
        this.attemptNumbers = new int[3];
        this.attemptNumbersPosition = 0;
        this.dialNumber = 0;
    }

    public void reset() {
        this.dialNumber = 0;
        this.attemptNumbers = new int[3];
        this.attemptNumbersPosition = 0;
    }

    public void turnLeft(int ticks) {
        if (ticks < 1) {
            throw new IllegalArgumentException("ticks must be greater than 0.");
        }
        dialNumber = (dialNumber - ticks + 40) % 40;
        attemptNumbers[attemptNumbersPosition] = dialNumber;
        attemptNumbersPosition = (attemptNumbersPosition + 1) % 3;
    }

    public void turnRight(int ticks) {
        if (ticks < 1) {
            throw new IllegalArgumentException("ticks must be greater than 0.");
        }
        dialNumber = (dialNumber + ticks + 40) % 40;
        attemptNumbers[attemptNumbersPosition] = dialNumber;
        attemptNumbersPosition = (attemptNumbersPosition + 1) % 3;
    }

    public boolean open() {
        return Arrays.equals(attemptNumbers, combination);
    }

}
