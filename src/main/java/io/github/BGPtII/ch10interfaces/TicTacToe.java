package io.github.BGPtII.ch10interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {

    private JLabel turnJLabel;
    private char currentPlayer;
    private JButton[][] gridJButtons;
    private JButton resetJButton;

    public TicTacToe() {
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel jPanelGrid = new JPanel(new GridLayout(3, 3));
        gridJButtons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gridJButtons[i][j] = new JButton();
                gridJButtons[i][j].addActionListener(this);
                jPanelGrid.add(gridJButtons[i][j]);
            }
        }
        add(jPanelGrid, BorderLayout.CENTER);

        turnJLabel = new JLabel("Player X's Turn");
        turnJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(turnJLabel, BorderLayout.NORTH);

        currentPlayer = 'X';

        resetJButton = new JButton("Start Over");
        resetJButton.addActionListener(e -> resetGame());
        add(resetJButton, BorderLayout.SOUTH);

        setSize(300, 300);
        setVisible(true);
    }

    private boolean checkForWinner() {
        for (int i = 0; i < 3; i++) {
            if (isWinningLine(gridJButtons[i][0], gridJButtons[i][1], gridJButtons[i][2])
                    || isWinningLine(gridJButtons[0][i], gridJButtons[1][i], gridJButtons[2][i])) {
                return true;
            }
        }
        return isWinningLine(gridJButtons[0][0], gridJButtons[1][1], gridJButtons[2][2]) ||
                isWinningLine(gridJButtons[0][2], gridJButtons[1][1], gridJButtons[2][0]);
    }

    private boolean isWinningLine(JButton b1, JButton b2, JButton b3) {
        return !b1.getText().isEmpty() && b1.getText().equals(b2.getText()) && b1.getText().equals(b3.getText());
    }

    private boolean checkForDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gridJButtons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gridJButtons[i][j].setText("");
            }
        }
        currentPlayer = 'X';
        turnJLabel.setText("Player " + currentPlayer + "'s Turn");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton clickedButton = (JButton) actionEvent.getSource();
        if (clickedButton.getText().isEmpty()) {
            clickedButton.setText(String.valueOf(currentPlayer));
            if (checkForWinner()) {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
                resetGame();
            }
            else if (checkForDraw()) {
                JOptionPane.showMessageDialog(this, "It's a draw!");
                resetGame();
            }
            else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                turnJLabel.setText("Player " + currentPlayer + "'s Turn");
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
