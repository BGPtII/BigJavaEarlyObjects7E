package io.github.BGPtII.ch2usingobjects;

import java.awt.Point;

/**
 * Constructs 2 point objects (3, 4), (-3, -4) & calculates the distance between them
 */
public class PointDistanceExample {
    public static void main(String[] args) {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(-3, -4);
        System.out.println("Expected: 10.0");
        System.out.println("Actual: " + point1.distance(point2));
    }
}
