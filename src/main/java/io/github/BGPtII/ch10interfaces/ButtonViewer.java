package io.github.BGPtII.ch10interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonViewer {

    private static final int FRAME_WIDTH = 210;
    private static final int FRAME_HEIGHT = 110;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton buttonA = new JButton("A");
        JButton buttonB = new JButton("B");
        buttonPanel.add(buttonA);
        buttonPanel.add(buttonB);

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));

        JLabel buttonACountJLabel = new JLabel("You've clicked A 0 times!");
        JLabel buttonBCountJLabel = new JLabel("You've clicked B 0 times!");
        buttonACountJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonBCountJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelPanel.add(buttonACountJLabel);
        labelPanel.add(buttonBCountJLabel);

        jFrame.add(buttonPanel, BorderLayout.NORTH);
        jFrame.add(labelPanel, BorderLayout.CENTER);

        class ClickListener implements ActionListener {

            private int clickCount;
            private JLabel countJLabel;
            private String buttonName;

            ClickListener(JLabel countJLabel, String buttonName) {
                this.clickCount = 0;
                this.countJLabel = countJLabel;
                this.buttonName = buttonName;
            }

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clickCount++;
                countJLabel.setText("You've clicked " + buttonName + " " + clickCount  + " times!");
            }
        }

        ClickListener buttonAClickListener = new ClickListener(buttonACountJLabel, "A");
        ClickListener buttonBClickListener = new ClickListener(buttonBCountJLabel, "B");
        buttonA.addActionListener(buttonAClickListener);
        buttonB.addActionListener(buttonBClickListener);

        jFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
