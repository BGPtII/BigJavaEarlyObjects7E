package io.github.BGPtII.ch2usingobjects;

import java.awt.Color;
import javax.swing.JFrame;

/**
 * Applies the brighter method on a Color object, adds it to a JFrame object as a background color
 */
public class JFrameBrighterExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(200, 200);
        Color testColor = new Color(50, 100, 150);
        System.out.println("Before: " + testColor);
        testColor = testColor.brighter();
        System.out.println("After: " + testColor);
        frame.getContentPane().setBackground(testColor);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
