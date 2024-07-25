package io.github.BGPtII.ch12objectorienteddesign.quiz;

import java.util.ArrayList;

public abstract class ChoiceQuestion extends Question {

    private ArrayList<String> choices;

    public ChoiceQuestion(String prompt, ArrayList<String> choices) {
        super(prompt);
        this.choices = choices;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    @Override
    public String getPrompt() {
        StringBuilder fullPrompt = new StringBuilder().append(super.getPrompt());
        for (int i = 0; i < choices.size(); i++) {
            fullPrompt.append("\n").append(i + 1).append(". ").append(choices.get(i));
        }
        return fullPrompt.toString();
    }

}
