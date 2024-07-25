package io.github.BGPtII.ch12objectorienteddesign.quiz;

public class TextQuestion extends Question {

    private String correctAnswer;

    public TextQuestion(String prompt, String correctAnswer) {
        super(prompt);
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public int checkAnswer() {
        return (correctAnswer.trim().equalsIgnoreCase(getEnteredAnswer().trim())) ? 1 : 0;
    }

}
