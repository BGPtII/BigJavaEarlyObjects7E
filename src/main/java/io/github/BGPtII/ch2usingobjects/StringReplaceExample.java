package io.github.BGPtII.ch2usingobjects;

/**
 * Replaces the string "Mississippi" with a new string of itself with the "i"s doubled,
 * and the "ss" with a single "s"
 * Also prints the length of the new Strings
 */
public class StringReplaceExample {
    public static void main(String[] args) {
        String s1 = "mississippi";
        String s2 = s1.replace("i", "ii");
        System.out.println(s2.length());
        String s3 = s2.replace("ss", "s");
        System.out.println(s3.length());
    }
}
