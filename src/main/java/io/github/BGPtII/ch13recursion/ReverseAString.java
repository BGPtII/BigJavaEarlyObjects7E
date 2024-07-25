package io.github.BGPtII.ch13recursion;

public class ReverseAString {

    public static String reverseString(String string) {
        if (string.length() < 2) {
            return string;
        }
        return reverseStringHelper(string, string.length() - 1);
    }

    private static String reverseStringHelper(String string, int index) {
        if (index < 0) {
            return "";
        }
        return string.charAt(index) + reverseStringHelper(string, index - 1);
    }

    public static void main(String[] args) {
        System.out.println("reverseString(\"Hello!\" - expected: \"!olleH\", actual: \"" + reverseString("Hello!") + "\".");
        System.out.println("reverseString(\"123Hey   321.\" - expected: \".123   yeH321\", actual: \"" + reverseString("123Hey   321.") + "\".");
        System.out.println("reverseString(\"   \" - expected: \"   \", actual: \"" + reverseString("   ") + "\".");
        System.out.println("reverseString(\"AbcbA\" - expected: \"AbcbA\", actual: \"" + reverseString("AbcbA") + "\".");
    }

}
