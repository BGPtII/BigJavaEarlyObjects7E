package io.github.BGPtII.ch2usingobjects;

import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 * Visually shows the translate method of the Rectangle class
 */
public class VisualRectangleTranslateExample {
    private static final Logger logger = Logger.getLogger(VisualRectangleTranslateExample.class.getName());
    private static final int SLEEP_DURATION_MS = 1000;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Rectangle box = new Rectangle(200, 500);
            frame.setBounds(box);
            frame.setVisible(true);

            try {
                JOptionPane.showMessageDialog(frame, "Click OK to continue");
                Thread.sleep(SLEEP_DURATION_MS);
            } catch (InterruptedException e) {
                logger.severe("Thread interrupted while sleeping: " + e.getMessage());
                Thread.currentThread().interrupt();
            }

            box.translate(50, 50);
            frame.setBounds(box);

            JOptionPane.showMessageDialog(frame, "Rectangle translated. Click OK to close.", "Translation Complete", JOptionPane.INFORMATION_MESSAGE);

            System.exit(0);
        });
    }
}
