package io.github.BGPtII.ch2usingobjects;

import java.awt.Rectangle;

/**
 * Prints the expected and actual location, width, and height of box after the call to add
 */
public class RectangleExample {
    public static void main(String[] args) {
        Rectangle box = new Rectangle(5, 10, 20, 30);
        box.add(0, 0);
        System.out.println("Expected location: 0, 0; actual location: " + box.getX() + ", " + box.getY());
        System.out.println("Expected width: 25; actual width: " + box.getWidth());
        System.out.println("Expected height: 40; actual height: " + box.getHeight());
    }
}
