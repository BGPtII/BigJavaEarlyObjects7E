package io.github.BGPtII.ch2usingobjects;

import java.awt.*;

/**
 * Constructs a Rectangle object, prints its expected and actual perimeter
 */
public class RectanglePerimeterExample {
    public static void main(String[] args) {
        Rectangle testRect = new Rectangle(20, 40);
        int testRectPerim = testRect.height * 2 + testRect.width * 2;
        System.out.println("Expected perimeter: 120");
        System.out.println("Actual perimeter: " + testRectPerim);
    }
}
