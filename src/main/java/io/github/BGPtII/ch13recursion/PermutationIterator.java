package io.github.BGPtII.ch13recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Computes all permutations of a String one at a time
 */
public class PermutationIterator {

    private String word;
    private int index;
    private List<String> permutations;


    public PermutationIterator (String word) {
        this.word = word.toLowerCase();
        index = 0;
        permutations = new ArrayList<>();
        generatePermutations("", this.word);
    }

    private void generatePermutations(String prefix, String remaining) {
        if (remaining.isEmpty()) {
            permutations.add(prefix);
        }
        else {
            generatePermutationsHelper(prefix, remaining, 0);
        }
    }

    private void generatePermutationsHelper(String prefix, String remaining, int position) {
        if (position == remaining.length()) {
            return;
        }
        char currentChar = remaining.charAt(position);
        String newPrefix = prefix + currentChar;
        String newRemaining = remaining.substring(0, position) + remaining.substring(position + 1);
        generatePermutations(newPrefix, newRemaining);
        generatePermutationsHelper(prefix, remaining, position + 1);
    }

    public String getNextPermutation() {
        if (hasMorePermutations()) {
            return permutations.get(index++);
        }
        return null;
    }

    public boolean hasMorePermutations() {
        return index < permutations.size();
    }

    public static void main(String[] args) {
        PermutationIterator eat = new PermutationIterator("eat");
        while (eat.hasMorePermutations()) {
            System.out.println(eat.getNextPermutation());
        }
        System.out.println();

        PermutationIterator bitten = new PermutationIterator("bitten");
        while (bitten.hasMorePermutations()) {
            System.out.println(bitten.getNextPermutation());
        }
    }

}
