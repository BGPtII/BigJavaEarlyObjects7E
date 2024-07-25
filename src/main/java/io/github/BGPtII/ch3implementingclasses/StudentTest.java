package io.github.BGPtII.ch3implementingclasses;

public class StudentTest {
    public static void main(String[] args) {
        Student bob = new Student("Bob");
        bob.addQuiz(5);
        bob.addQuiz(5);
        bob.addQuiz(5);
        bob.addQuiz(5);
        System.out.println("bob.getAverageScore()");
        System.out.println("Expected: 5.0");
        System.out.println("Actual: " + bob.getAverageScore() + "\n");
    }
}
