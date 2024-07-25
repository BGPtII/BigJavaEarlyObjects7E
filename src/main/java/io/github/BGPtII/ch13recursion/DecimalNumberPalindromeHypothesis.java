package io.github.BGPtII.ch13recursion;

import java.math.BigInteger;
import java.util.Random;

/**
 * Based off the mathematical hypothesis that: given any decimal number, adding the number
 * and its reversal, will eventually reach a palindrome
 */
public class DecimalNumberPalindromeHypothesis {

    public static BigInteger findSolutionNumber(BigInteger n) {
        BigInteger m = new BigInteger(reverseString(n.toString()));
        if (isPalindrome(n)) {
            BigInteger sum = n.add(m);
            if (isPalindrome(sum)) {
                return m;
            }
        }
        return findSolutionNumber(n.add(BigInteger.ONE));
    }

    private static boolean isPalindrome(BigInteger n) {
        String nStr = n.toString();
        String reversed = reverseString(nStr);
        return nStr.equals(reversed);
    }

    private static String reverseString(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        BigInteger startNumber = new BigInteger(16, new Random());
        System.out.println("Starting number: " + startNumber);
        BigInteger firstValueFound = findSolutionNumber(startNumber);
        BigInteger firstValueFoundReversed = new BigInteger(reverseString(firstValueFound.toString()));
        BigInteger sum = firstValueFound.add(firstValueFoundReversed);
        System.out.println(firstValueFound + " + " + firstValueFoundReversed + " = " + sum);
    }

}
