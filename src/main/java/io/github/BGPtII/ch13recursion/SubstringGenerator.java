package io.github.BGPtII.ch13recursion;

import java.util.ArrayList;

public class SubstringGenerator {

    public static ArrayList<String> getAllSubstrings(String string) {
        ArrayList<String> substrings = new ArrayList<>();
        getAllSubstringsHelper(string, 0, substrings);
        return substrings;
    }

    private static void getAllSubstringsHelper(String string, int index, ArrayList<String> substrings) {
        if (index == string.length()) {
            return;
        }
        generateSubstrings(string, index, index, substrings);
        getAllSubstringsHelper(string, index + 1, substrings);
    }

    private static void generateSubstrings(String string, int start, int end, ArrayList<String> substrings) {
        if (end == string.length()) {
            return;
        }
        substrings.add(string.substring(start, end + 1));
        generateSubstrings(string, start, end + 1, substrings);
    }

    public static void main(String[] args) {
        System.out.println(getAllSubstrings("Power-washer"));
        System.out.println(getAllSubstrings("as"));
        System.out.println(getAllSubstrings("a"));
    }

}
