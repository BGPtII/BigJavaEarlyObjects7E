package io.github.BGPtII.ch7arraysandarraylists;

import java.util.Random;

/**
 * Initializes an array with ten random integers and then prints
 * four lines of output, containing:
 * every element at an even index,
 * every even element,
 * all elements in reverse order,
 * only the first and last element.
 */
public class TenRandomIntDetails {
    public static void main(String[] args) {
        Random random = new Random();
        int[] randomIntegers = new int[10];

        for (int i = 0; i < randomIntegers.length; i++) {
            randomIntegers[i] = random.nextInt(Integer.MAX_VALUE);
        }

        System.out.print("Every element at an even index: ");
        for (int i = 0; i < randomIntegers.length; i += 2) {
            System.out.print(randomIntegers[i] + " ");
        }
        System.out.println();

        System.out.print("Every even element: ");
        for (int randomInteger : randomIntegers) {
            if (randomInteger % 2 == 0) {
                System.out.print(randomInteger + " ");
            }
        }
        System.out.println();

        System.out.print("All elements in reverse order: ");
        for (int i = randomIntegers.length - 1; i >= 0; i--) {
            System.out.print(randomIntegers[i] + " ");
        }
        System.out.println();

        System.out.print("Only the first and last element: ");
        System.out.print("First = " + randomIntegers[0]);
        System.out.print(", last = " + randomIntegers[randomIntegers.length - 1]);
    }
}
