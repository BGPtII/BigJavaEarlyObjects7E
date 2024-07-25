package io.github.BGPtII.ch15javacollectionsframework;

import java.awt.Point;
import java.util.Objects;

public class LabeledPoint implements Comparable<LabeledPoint> {

    private Point location;
    private String label;

    public LabeledPoint(int x, int y, String label) {
        if (label.isEmpty()) {
            throw new IllegalArgumentException("label can't be blank.");
        }
        location = new Point(x, y);
        this.label = label;
    }

    public Point getLocation() {
        return location;
    }

    public int getX() {
        return location.x;
    }

    public int getY() {
        return location.y;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public int hashCode() {
        return location.hashCode() + label.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LabeledPoint lP = (LabeledPoint) obj;
        return location.equals(lP.getLocation()) && Objects.equals(getLabel(), lP.getLabel());
    }

    @Override
    public int compareTo(LabeledPoint lP) {
        int comparison = Integer.compare(getX(), lP.getX());
        if (comparison != 0) {
            return comparison;
        }
        comparison = Integer.compare(getY(), lP.getY());
        if (comparison !=0) {
            return comparison;
        }
        return getLabel().compareTo(lP.getLabel());
    }

    @Override
    public String toString() {
        return "LabeledPoint{location=" + location.toString() + ",label='" + label + "'}";
    }
}
