package io.github.BGPtII.ch12objectorienteddesign.quiz;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Does not allow duplicate correct answers.
 */
public class MultipleAnswerChoiceQuestion extends ChoiceQuestion {

    private HashSet<String> correctAnswers;

    public MultipleAnswerChoiceQuestion(String prompt, ArrayList<String> choices, HashSet<String> correctAnswers) {
        super(prompt, choices);
        this.correctAnswers = correctAnswers;
    }

    public HashSet<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(HashSet<String> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public void removeCorrectAnswer(String correctAnswer) {
        correctAnswers.remove(correctAnswer);
    }

    public void addCorrectAnswer(String correctAnswer) {
        correctAnswers.add(correctAnswer);
    }

    /**
     * Format must be: "answer1, answer2, answer3" - answers are comma separated, doesn't take into account the number
     * of spaces between answers.
     * Each unique correct answer adds a point, every incorrect answer removes a point; there can be a negative
     * score returned.
     * Returns the points received for the question.
     */
    @Override
    public int checkAnswer() {
        String[] enteredAnswers = super.getEnteredAnswer().split(",\\s*");
        HashSet<String> foundCorrectAnswers = new HashSet<>();
        int points = 0;
        for (int i = 0; i < enteredAnswers.length; i++) {
            String enteredAnswer = enteredAnswers[i].trim();
            if (correctAnswers.contains(enteredAnswer) && !foundCorrectAnswers.contains(enteredAnswer)) {
                points++;
                foundCorrectAnswers.add(enteredAnswer);
            }
            else {
                points--;
            }
        }
        return points;
    }

}
