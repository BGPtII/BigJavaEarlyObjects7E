package io.github.BGPtII.ch12objectorienteddesign.quiz;

public class NumberQuestion extends Question {

    private double correctAnswer;

    public NumberQuestion(String prompt, double correctAnswer) {
        super(prompt);
        this.correctAnswer = correctAnswer;
    }

    public double getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(double correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int checkAnswer() {
        try {
            return (correctAnswer == Double.parseDouble(getEnteredAnswer())) ? 1 : 0;
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }

}
