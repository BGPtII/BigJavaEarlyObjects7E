package io.github.BGPtII.ch16basicdatastructures;

import java.util.NoSuchElementException;

/**
 * Implements a hash set using separate chaining
 */
public class HashSetSeparateChaining {

    private HashSetIterator iterator;
    private Node[] buckets;
    private int currentSize;

    private int p;
    private int a;
    private int b;

    /**
     * Constructs a hash table
     * @param bucketsLength the length of the buckets array
     */
    public HashSetSeparateChaining(int bucketsLength) {
        if (bucketsLength < 0) {
            throw new IllegalArgumentException("bucketsLength must be > 0.");
        }
        iterator = new HashSetIterator();
        buckets = new Node[bucketsLength];
        currentSize = 0;
        recalculateCHCParameters();
    }

    /**
     * Load factor is F = n/L, where n is the number of elements, and L is the table length
     * @return F, the load factor
     */
    private double getLoadFactor() {
        return (double) currentSize / buckets.length;
    }

    /**
     * Finds the first prime number >= than the given number
     * @param n the number to start from
     * @return the first prime number > n
     */
    private int getPrime(int n) {
        while (true) {
            if (isPrime(n)) {
                return n;
            }
            n++;
        }
    }

    /**
     * Checks if a number is prime
     * @param n the number to check
     * @return whether the number is prime
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
     * Recalculates the parameters for the compressed hash code; used when resize() occurs
     */
    private void recalculateCHCParameters() {
        p = getPrime(buckets.length + 1);
        a = 1 + (int) (Math.random() * (p - 1));
        b = 1 + (int) (Math.random() * (p - 1));
    }

    /**
     * Gets the compressed hash code using the multiply-add-divide algorithm
     * @param x the object to get the compressed hash code of
     * @return the compressed hash code
     */
    private int getCompressedHashCode(Object x) {
        int h = x.hashCode();
        return Math.abs(((a * h + b) % p) % buckets.length);
    }

    private void resize(int newSize) {
        Node[] oldBuckets = buckets;
        buckets = new Node[newSize];
        currentSize = 0;

        recalculateCHCParameters();

        for (Node bucket : oldBuckets) {
            Node current = bucket;
            while (current != null) {
                add(current.getData());
                current = current.getNext();
            }
        }
    }

    /**
     * Tests for set membership
     * @param x an object
     * @return whether x is an element in the set
     */
    public boolean contains(Object x) {
        int h = getCompressedHashCode(x);
        Node current = buckets[h];
        while (current != null) {
            if (current.getData().equals(x)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Adds an element to the set
     * @param x an object
     * @return whether x is a new object in the set
     */
    public boolean add(Object x) {
        int h = getCompressedHashCode(x);
        Node current = buckets[h];
        while (current != null) {
            if (current.getData().equals(x)) {
                return false;
            }
            current = current.getNext();
        }
        Node newNode = new Node();
        newNode.setData(x);
        newNode.setNext(buckets[h]);
        buckets[h] = newNode;
        currentSize++;
        if (getLoadFactor() > 1) {
            resize(buckets.length * 2);
        }
        return true;
    }

    /**
     * Removes an object from the set
     * @param x an object
     * @return whether x wasn't already in the set
     */
    public boolean remove(Object x) {
        int h = getCompressedHashCode(x);
        Node current = buckets[h];
        Node previous = null;
        while (current != null) {
            if (current.getData().equals(x)) {
                if (previous == null) {
                    buckets[h] = current.getNext();
                }
                else {
                    previous.setNext(current.getNext());
                }
                currentSize--;

                if (getLoadFactor() < 0.5) {
                    resize(buckets.length / 2);
                }
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    public HashSetIterator iterator() {
        return new HashSetIterator();
    }

    /**
     * Gets the number of elements in the set
     * @return the number of elements
     */
    public int size() {
        return currentSize;
    }

    class HashSetIterator {
        private int bucketIndex;
        private Node previous;
        private Node current;
        private Node next;

        /**
         * Constructs a hash set iterator that points to the first element of the hash set
         */
        public HashSetIterator() {
            bucketIndex = -1;
            previous = null;
            current = null;
            next = null;
        }

        public boolean hasNext() {
            if (current != null && current.getNext() != null) {
                next = current.getNext();
                return true;
            }
            for (int b = bucketIndex + 1; b < buckets.length; b++) {
                if (buckets[b] != null) {
                    bucketIndex = b;
                    next = buckets[b];
                    return true;
                }
            }
            return false;
        }

        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            previous = current;
            current = next;
            next = null;
            return current.getData();
        }

        public Object remove() {
            if (current == null) {
                throw new IllegalStateException();
            }
            Object nodeToRemove = current.getData();

            if (previous != null) {
                previous.setNext(next);
                next = current.getNext();
            }
            current = previous;

            currentSize--;
            if (getLoadFactor() < 0.5) {
                resize(buckets.length / 2);
            }
            return nodeToRemove;
        }

    }

}
