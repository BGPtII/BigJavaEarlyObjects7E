package io.github.BGPtII.ch10interfaces;

public class Quiz implements Measurable {

    public enum GradeLetter {
        F, D_MINUS, D, D_PLUS, C_MINUS, C, C_PLUS, B_MINUS, B, B_PLUS, A_MINUS, A, A_PLUS;
    }

    private int score;
    private GradeLetter gradeLetter;

    public Quiz(int score, GradeLetter gradeLetter) {
        if (score < 0) {
            throw new IllegalArgumentException("score must be 0 or greater.");
        }
        this.score = score;
        this.gradeLetter = gradeLetter;
    }

    @Override
    public double getMeasure() {
        return score;
    }
}
