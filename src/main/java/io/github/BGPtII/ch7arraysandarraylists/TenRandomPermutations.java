package io.github.BGPtII.ch7arraysandarraylists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Produces ten random permutations of the numbers 1 to 10. Follows this algorithm:
 * make a second array and fill it with the numbers 1 to 10,
 * repeat 10 times -
 * pick a random position in the second array,
 * remove the element at the position from the second array,
 * append the removed element to the permutation array.
 */
public class TenRandomPermutations {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> initialTenRandomIntegers = new ArrayList<>();
        int[] permutationArray = new int[10];

        for (int i = 1; i <= 10; i++) {
            initialTenRandomIntegers.add(i);
        }
        System.out.println("Initial ten random: " + initialTenRandomIntegers);

        for (int i = 10; i > 0; i--) {
            int randomIndex = random.nextInt(i);
            int selectedNumber = initialTenRandomIntegers.remove(randomIndex);
            permutationArray[i - 1] = selectedNumber;
        }
        System.out.println("Permutation: " + Arrays.toString(permutationArray));
    }
}
