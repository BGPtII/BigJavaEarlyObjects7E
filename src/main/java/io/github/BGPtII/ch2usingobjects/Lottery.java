package io.github.BGPtII.ch2usingobjects;

import java.util.Random;

/**
 * Picks a combination in a lottery. In this lottery, players can choose 6 numbers
 * (possibly repeated) between 1 and 49 (inclusive)
 */
public class Lottery {
    public static void main(String[] args) {
        Random lottery = new Random();
        System.out.println("Play this combination, it'll make you rich!");
        System.out.println((lottery.nextInt(49) + 1) + " " + (lottery.nextInt(49) + 1) + " " +
                (lottery.nextInt(49) + 1) + " " + (lottery.nextInt(49) + 1) + " " +
                (lottery.nextInt(49) + 1) + " " + (lottery.nextInt(49) + 1));
    }
}

