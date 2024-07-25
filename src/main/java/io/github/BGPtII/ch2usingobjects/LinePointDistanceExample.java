package io.github.BGPtII.ch2usingobjects;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Constructs a line joining the points (100, 100) and (200, 200),
 * then constructs points (100, 200), (150, 150), and (250, 50).
 * Prints the distance from the line to each of the three points, using the ptSegDist method of the Line2D class.
 */
public class LinePointDistanceExample {
    public static void main(String[] args) {
        Line2D.Double line1 = new Line2D.Double(100, 100, 200, 200);
        Point2D.Double p1 = new Point2D.Double(100, 200);
        Point2D.Double p2 = new Point2D.Double(150, 150);
        Point2D.Double p3 = new Point2D.Double(250, 50);

        System.out.println("Distance from line1 to p1: " + line1.ptSegDist(p1));
        System.out.println("Distance from line1 to p2: " + line1.ptSegDist(p2));
        System.out.println("Distance from line1 to p3: " + line1.ptSegDist(p3));
    }
}
