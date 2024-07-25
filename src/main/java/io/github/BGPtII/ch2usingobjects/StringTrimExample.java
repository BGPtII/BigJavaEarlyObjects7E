package io.github.BGPtII.ch2usingobjects;

/**
 * A demonstration of the trim method on Strings, showing which spaces are removed
 */
public class StringTrimExample {
    public static void main(String[] args) {
        String trimTest = "   Testing!   Wow!";
        System.out.println("Before trim method: " + trimTest);
        System.out.println("After trim method: " + trimTest.trim());
        System.out.println();

        trimTest = "...Testing!     ";
        System.out.println("Before trim method: " + trimTest + " Trim removes the leading spaces.");
        System.out.println("After trim method: " + trimTest.trim() + " Trim removes the leading spaces.");
        System.out.println();

        trimTest = "     ...test...     ";
        System.out.println("Before trim method: " + trimTest + " Trim removes the leading spaces.");
        System.out.println("After trim method: " + trimTest.trim() + " Trim removes the leading spaces.");
    }
}
