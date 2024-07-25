package io.github.BGPtII.ch2usingobjects;

import java.util.Random;

/**
 * Simulates the rolling of a 6-sided die by printing a random number between 1 & 6
 */
public class DieRoll {
    public static void main(String[] args) {
        Random generator = new Random();
        System.out.println(generator.nextInt(6) + 1);
    }
}
