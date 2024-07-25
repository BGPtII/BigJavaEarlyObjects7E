package io.github.BGPtII.ch2usingobjects;

import java.awt.Color;

/**
 * Applies the darker method on the Color.RED object
 */
public class ColourDarkerExample {
    public static void main(String[] args) {
        System.out.println("Before: " + Color.RED);
        System.out.println("After: " + Color.RED.darker().darker());
    }
}
