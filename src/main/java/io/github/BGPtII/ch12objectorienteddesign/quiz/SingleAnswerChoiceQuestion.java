package io.github.BGPtII.ch12objectorienteddesign.quiz;

import java.util.ArrayList;

public class SingleAnswerChoiceQuestion extends ChoiceQuestion {

    private String correctAnswer;

    public SingleAnswerChoiceQuestion(String prompt, ArrayList<String> choices, String correctAnswer) {
        super(prompt, choices);
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int checkAnswer() {
        return (correctAnswer.trim().equalsIgnoreCase(getEnteredAnswer().trim())) ? 1 : 0;
    }

}
