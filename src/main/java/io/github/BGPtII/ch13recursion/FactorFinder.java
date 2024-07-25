package io.github.BGPtII.ch13recursion;

import java.util.ArrayList;

public class FactorFinder {

    private static void getFactorsHelper(int n, int d, ArrayList<Integer> factors) {
        if (d == 0) {
            return;
        }
        if (n % d == 0) {
            factors.add(d);
        }
        if (d > 0) {
            getFactorsHelper(n, d - 1, factors);
        }
        else {
            getFactorsHelper(n, d + 1, factors);
        }
    }

    public static ArrayList<Integer> getFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        getFactorsHelper(n, Math.abs(n), factors);
        getFactorsHelper(n, -Math.abs(n), factors);
        return factors;
    }

    public static void main(String[] args) {
        System.out.println(getFactors(5));
        System.out.println(getFactors(100));
        System.out.println(getFactors(-100));
        System.out.println(getFactors(0));
    }

}
