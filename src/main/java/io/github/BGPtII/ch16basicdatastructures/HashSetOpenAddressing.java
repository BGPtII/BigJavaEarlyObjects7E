package io.github.BGPtII.ch16basicdatastructures;

/**
 * Implements a hash table using open addressing using a double hashing technique.
 * The size of the array only uses prime numbers to greatly reduce collision occurrences.
 * Uses prime numbers for sizing to optimize the reduction of collision occurrences.
 * Marks deleted elements with an empty INACTIVE Object to maintain table cleanliness.
 */
public class HashSetOpenAddressing {

    private Object[] table;
    private int currentSize;
    private static final Object INACTIVE = new Object();

    public HashSetOpenAddressing() {
        final int INITIAL_SIZE = 11;
        table = new Object[INITIAL_SIZE];
        currentSize = 0;
    }

    private double getLoadFactor() {
        return (double) currentSize / table.length;
    }

    private void resize(int newSize) {
        int closestPrime = getClosestPrime(newSize);
        Object[] oldTable = table;
        table = new Object[closestPrime];
        currentSize = 0;

        for (Object element : oldTable) {
            if (element != null && element != INACTIVE) {
                add(element);
            }
        }
    }

    /**
     * Finds the prime number closest to but not n
     * @param n the number to find the closest prime to
     * @return the prime number closest to n, or -1 if no prime is found that is less than n
     */
    private int getClosestPrime(int n) {
        if (n <= 1) {
            return -1;
        }
        for (int i = n - 1; i >= 2; i--) {
            if (isPrime(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks if a number is prime
     * @param n the number to check
     * @return whether the number is a prime number
     */
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Computes the initial position; uses the formula:
     * h2(k) = 1 + k % q, where k is the original hash key, q is a prime number less than L
     * @return the value computed from this formula for h2(k)
     */
    private int firstHash(Object x) {
        return (1 + Math.abs(x.hashCode())) % getClosestPrime(table.length);
    }

    /**
     * Determines the step size for probing using the formula: (h1 + i * h2(k)) % L
     * @return the value computed from this formula
     */
    private int secondHash(Object x, int i) {
        int h1 = Math.abs(x.hashCode()) % table.length;
        int h2 = firstHash(x);
        return (h1 + i * h2) % table.length;
    }

    /**
     * Adds an object, uses a probing sequence if a hash collision occurs
     * @param x the object to add
     * @return whether the object was successfully added (
     */
    public boolean add(Object x) {
        if (getLoadFactor() > 0.8) {
            resize(table.length * 2);
        }

        int h1 = firstHash(x);
        int i = 0;
        int h2 = secondHash(x, i);
        while (table[(h1 + i * h2) % table.length] != null && table[(h1 + i * h2) % table.length] != INACTIVE) {
            if (table[(h1 + i * h2) % table.length].equals(x)) {
                return false;
            }
            h2 = secondHash(x, ++i);
        }

        table[(h1 + i * h2) % table.length] = x;
        currentSize++;
        return true;
    }
    public boolean remove(Object x) {
        if (getLoadFactor() < 0.5) {
            resize(table.length / 2);
        }

        int h1 = firstHash(x);
        int i = 0;
        int h2 = secondHash(x, i);
        while (table[(h1 + i * h2) % table.length] != null) {
            if (table[(h1 + i * h2) % table.length].equals(x)) {
                break;
            }
            h2 = secondHash(x, ++i);
        }
        int indexToRemove = (h1 + i * h2) % table.length;
        if (table[indexToRemove] == null) {
            return false;
        }

        table[indexToRemove] = INACTIVE;
        currentSize--;

        int originalH2 = h2;
        i = 1;
        int nextIndex = (indexToRemove + i * originalH2) % table.length;
        while (table[nextIndex] != null) {
            Object currentElement = table[nextIndex];
            table[nextIndex] = null;
            currentSize--;
            add(currentElement);
            nextIndex = (indexToRemove + ++i * originalH2) % table.length;
        }
        return true;
    }

}
