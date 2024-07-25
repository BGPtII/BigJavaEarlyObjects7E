package io.github.BGPtII.ch15javacollectionsframework;

import java.util.HashSet;
import java.util.Set;

public class SieveOfEratosthenes {

    /**
     * Computes all prime numbers up to n
     * @param n the number at which the prime numbers should stop at
     */
    public static Set<Integer> computeSieveOfEratosthenes(int n) {
        Set<Integer> set = new HashSet<>();
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater than 0.");
        }
        for (int i = 2; i < n; i++) {
            if ((i % 2 != 0 || i == 2) && ((i % 3 != 0 && Math.sqrt(i) < n) || i == 3)) {
                set.add(i);
            }
        }
        return set;
    }

    // For testing purposes
    public static void main(String[] args) {
        Set<Integer> primeNumbers = computeSieveOfEratosthenes(30);
        System.out.println(primeNumbers);
    }

}
