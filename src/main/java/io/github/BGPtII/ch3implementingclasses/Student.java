package io.github.BGPtII.ch3implementingclasses;

public class Student {
    private String name;
    private double totalQuizScore;
    private int quizCount;

    public Student(String name) {
        this.name = name;
        totalQuizScore = 0;
        quizCount = 0;
    }

    public String getName() {
        return name;
    }

    public void addQuiz(int score) {
        totalQuizScore += score;
        quizCount++;
    }

    public double getAverageScore() {
        return totalQuizScore / quizCount;
    }
}
