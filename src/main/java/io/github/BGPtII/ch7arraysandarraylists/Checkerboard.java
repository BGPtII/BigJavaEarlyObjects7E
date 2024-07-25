package io.github.BGPtII.ch7arraysandarraylists;


import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Checkerboard extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int size = 8;
        int squareSize = getWidth() / size;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.BLACK);
                }
                else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
            }
        }
    }
}
