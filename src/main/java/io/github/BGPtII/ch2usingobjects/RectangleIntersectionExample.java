package io.github.BGPtII.ch2usingobjects;

import java.awt.Rectangle;

/**
 * Constructs two rectangle objects, prints them and then prints the rectangle object that describes the intersection.
 * Prints result of the intersection method when the rectangles do not overlap
 */
public class RectangleIntersectionExample {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(50, 100);
        Rectangle r2 = new Rectangle(50, 0, 50, 100);
        Rectangle r3 = r1.intersection(r2);
        System.out.println("Rectangle r3: " + r3);
        System.out.println("r3 is empty because its width is 0.");
    }
}
