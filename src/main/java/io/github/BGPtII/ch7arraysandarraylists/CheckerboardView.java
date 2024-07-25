package io.github.BGPtII.ch7arraysandarraylists;

import javax.swing.JFrame;

public class CheckerboardView {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Checkerboard");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 500);
        Checkerboard checkerboard = new Checkerboard();
        jFrame.add(checkerboard);
        jFrame.setVisible(true);
    }
}
