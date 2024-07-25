package io.github.BGPtII.ch6loops;

public class PrimeGenerator {
    private int currentNumber;

    public PrimeGenerator() {
        this.currentNumber = 1;
    }

    public int nextPrime() {
        currentNumber++;
        while (!isPrime(currentNumber)) {
            currentNumber++;
        }
        return currentNumber;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
