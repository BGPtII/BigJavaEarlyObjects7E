package io.github.BGPtII.ch7arraysandarraylists;

import java.util.Random;

/**
 * Creates a pseudorandom sequence of die rolls, then encloses the adjacent, same values (runs)
 * in parentheses
 */
public class Random20DieTossSequenceFinder {

    public static void main(String[] args) {
        Random random = new Random();
        int[] randomDieTosses = new int[20];
        for (int i = 0; i < randomDieTosses.length; i++) {
            randomDieTosses[i] = random.nextInt(6) + 1;
        }

        boolean inRun = false;
        for (int i = 0; i < randomDieTosses.length; i++) {
            boolean isStartingRun = i != randomDieTosses.length - 1 && randomDieTosses[i] == randomDieTosses[i + 1];
            if (inRun) {
                if (randomDieTosses[i] != randomDieTosses[i - 1]) {
                    System.out.print(") ");
                    inRun = false;
                }
            }
            else {
                if (isStartingRun) {
                    System.out.print("(");
                    inRun = true;
                }
            }
            System.out.print(randomDieTosses[i]);
            if (!inRun || isStartingRun) {
                System.out.print(" ");
            }

        }
        if (inRun) {
            System.out.print(")");
        }
    }
}
