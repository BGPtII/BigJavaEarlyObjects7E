package io.github.BGPtII.ch14sortingandsearching;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Follows the naming convention "sec3_14.txt, sec10_1.txt, etc.";
 * Each string is broken into its string, integer, integer, string components:
 * EX: sec3_14.txt becomes "sec", 3, 14, "txt" and sec10_1.txt becomes "sec", 10, 1, "txt"
 */
public class TextNumNumStringComparator implements Comparator<String> {
    private Pattern pattern = Pattern.compile("^([a-zA-Z]+)(\\d+)_(\\d+)\\.(\\w+)$");

    @Override
    public int compare(String s1, String s2) {
        Matcher matcher1 = pattern.matcher(s1);
        Matcher matcher2 = pattern.matcher(s2);
        if (!matcher1.matches()) {
            throw new IllegalArgumentException("First string does not match the expected pattern.");
        }
        if (!matcher2.matches()) {
            throw new IllegalArgumentException("Second string does not match the expected pattern.");
        }
        int text1Comparison = matcher1.group(1).compareTo(matcher2.group(1));
        if (text1Comparison != 0) {
            return text1Comparison;
        }
        int int1Comparison = Integer.compare(Integer.parseInt(matcher1.group(2)), Integer.parseInt(matcher2.group(2)));
        if (int1Comparison != 0) {
            return int1Comparison;
        }
        int int2Comparison = Integer.compare(Integer.parseInt(matcher1.group(3)), Integer.parseInt(matcher2.group(3)));
        if (int2Comparison != 0) {
            return int2Comparison;
        }
        return matcher1.group(4).compareTo(matcher2.group(4));
    }

}
