package io.github.BGPtII.ch2usingobjects;

import java.math.BigInteger;

/**
 * Prints the square, fourth power, and eighth power of a, using one of the methods of the BigInteger class
 */
public class BigIntegerPowers {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("12345678987654321");
        System.out.println(a.pow(2));
        System.out.println(a.pow(4));
        System.out.println(a.pow(8));
    }
}
