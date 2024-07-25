package io.github.BGPtII.ch15javacollectionsframework;

import java.util.TreeSet;

public class LabeledPointDemo {

    public static void main(String[] args) {
        TreeSet<LabeledPoint> labeledPoints = new TreeSet<>() {
            {
                add(new LabeledPoint(1, 1, "lP1"));
                add(new LabeledPoint(1, 1, "lP2"));
                add(new LabeledPoint(2, 1, "lP3"));
                add(new LabeledPoint(5, 6, "lP4"));
                add(new LabeledPoint(-1, -4, "lP5"));
                add(new LabeledPoint(-5, -2, "lP6"));
                add(new LabeledPoint(12, 45, "lP7"));
                add(new LabeledPoint(2, 4, "lP8"));
                add(new LabeledPoint(34, 2, "lP9"));
                add(new LabeledPoint(12, 13, "lP10"));
            }
        };

        for (LabeledPoint labeledPoint : labeledPoints) {
            System.out.println(labeledPoint);
        }
    }

}
