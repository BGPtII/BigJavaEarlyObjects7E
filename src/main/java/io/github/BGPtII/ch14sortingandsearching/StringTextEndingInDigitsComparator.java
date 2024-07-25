package io.github.BGPtII.ch14sortingandsearching;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Follows the naming convention "dir1, dir10, dir11, dir12, dir2, dir3, etc.";
 * first compares the part before the digits as strings, then compares the numeric values of the digits:
 * EX: dir1 becomes "dir" and 1, dir12 becomes "dir" and 12.
 */
public class StringTextEndingInDigitsComparator implements Comparator<String> {
    private final Pattern PATTERN = Pattern.compile("^(.*?)(\\d+)$");

    @Override
    public int compare(String s1, String s2) {
        String[] strings = new String[] { getStartingText(s1), getStartingText(s2) };
        int[] ints = new int[] { getEndingDigits(s1), getEndingDigits(s2) };

        int textComparison = strings[0].compareTo(strings[1]);
        if (textComparison != 0) {
            return textComparison;
        }
        return Integer.compare(ints[0], ints[1]);
    }

    public String getStartingText(String s) {
        Matcher matcher = PATTERN.matcher(s);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        else {
            throw new IllegalArgumentException("Input string does not match the expected pattern.");
        }
    }

    public int getEndingDigits(String s) {
        Matcher matcher = PATTERN.matcher(s);
        if (matcher.matches()) {
            return Integer.parseInt(matcher.group(2));
        }
        else {
            throw new IllegalArgumentException("Input string does not match the expected pattern.");
        }
    }

}
