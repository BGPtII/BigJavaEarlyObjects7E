package io.github.BGPtII.ch12objectorienteddesign.quiz;

public abstract class Question {

    private String prompt;
    private String enteredAnswer;

    public Question(String prompt) {
        this.prompt = prompt;
        this.enteredAnswer = "";
    }

    public String getPrompt() {
        return prompt;
    }

    public String getEnteredAnswer() {
        return enteredAnswer;
    }

    public void setEnteredAnswer(String enteredAnswer) {
        this.enteredAnswer = enteredAnswer;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public abstract int checkAnswer();

}
