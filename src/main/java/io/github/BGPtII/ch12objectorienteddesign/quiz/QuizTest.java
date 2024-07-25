package io.github.BGPtII.ch12objectorienteddesign.quiz;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuizTest {

    private Quiz quiz = new Quiz();

    @Test
    public void testQuizQuestions() {
        String prompt1 = "What is the correct option?";
        ArrayList<String> choices1 = new ArrayList<>() {
            {
                add("test1");
                add("test2");
                add("test3");
                add("test4");
            }
        };
        HashSet<String> correctAnswers1 = new HashSet<>() {
            {
                add("test2");
                add("test4");
            }
        };
        MultipleAnswerChoiceQuestion multipleAnswerChoiceQuestion1 = new MultipleAnswerChoiceQuestion(prompt1, choices1, correctAnswers1);

        multipleAnswerChoiceQuestion1.setEnteredAnswer("    test2  ,     test4");
        assertEquals(2, multipleAnswerChoiceQuestion1.checkAnswer());

        multipleAnswerChoiceQuestion1.setEnteredAnswer("   test3,    test2  ");
        assertEquals(0, multipleAnswerChoiceQuestion1.checkAnswer());

        multipleAnswerChoiceQuestion1.setEnteredAnswer("test1, test3");
        assertEquals(-2, multipleAnswerChoiceQuestion1.checkAnswer());

        String prompt2 = "What is the correct test number?";
        String correctAnswer1 = "test1";
        TextQuestion textQuestion1 = new TextQuestion(prompt2, correctAnswer1);

        textQuestion1.setEnteredAnswer("test1");
        assertEquals(1, textQuestion1.checkAnswer());

        textQuestion1.setEnteredAnswer("wrong1");
        assertEquals(0, textQuestion1.checkAnswer());


        String prompt3 = "What is the correct number?";
        double answer3 = 3;
        NumberQuestion numberQuestion1 = new NumberQuestion(prompt3, answer3);

        numberQuestion1.setEnteredAnswer("3.000000");
        assertEquals(1, numberQuestion1.checkAnswer());

        numberQuestion1.setCorrectAnswer(3.00000);
        numberQuestion1.setEnteredAnswer("3");
        assertEquals(1, numberQuestion1.checkAnswer());

        quiz.addQuestion(multipleAnswerChoiceQuestion1);
        quiz.addQuestion(textQuestion1);
        quiz.addQuestion(numberQuestion1);

        assertEquals("""
                What is the correct option?
                1. test1
                2. test2
                3. test3
                4. test4""", quiz.getQuestion(0).getPrompt());

        multipleAnswerChoiceQuestion1.addCorrectAnswer("test6");
        multipleAnswerChoiceQuestion1.setEnteredAnswer("test2, test4, test6");
        assertEquals(3, quiz.getQuestion(0).checkAnswer());
    }

    @Test
    public void testAddQuestionsFromFileCorrectFormat() throws FileNotFoundException {
        quiz.addQuestionsFromFile("src\\bigjavaearlyobjectsexercisesprojects\\chaptertwelve\\programmingprojects\\samplequizcorrectformat.txt");

        ArrayList<Question> questions = quiz.getQuestions();
        assertEquals(16, questions.size());

        TextQuestion textQuestion1 = (TextQuestion) questions.get(0);
        assertEquals("Which Java reserved word is used to declare a subclass?", textQuestion1.getPrompt());
        assertEquals("extends", textQuestion1.getCorrectAnswer());

        NumberQuestion numberQuestion1 = (NumberQuestion) questions.get(3);
        assertEquals("What is the square root of 2?", numberQuestion1.getPrompt());
        assertEquals(00001.41421356000000, numberQuestion1.getCorrectAnswer());

        SingleAnswerChoiceQuestion singleAnswerQuestion1 = (SingleAnswerChoiceQuestion) questions.get(1);
        assertEquals("""
                What is the original name of the Java language?
                1. *7
                2. C--
                3. Oak
                4. Gosling""", singleAnswerQuestion1.getPrompt());
        assertEquals("Oak", singleAnswerQuestion1.getCorrectAnswer());
        assertEquals(4, singleAnswerQuestion1.getChoices().size());

        MultipleAnswerChoiceQuestion multipleAnswerQuestion1 = (MultipleAnswerChoiceQuestion) questions.get(2);
        assertEquals("""
                Which of the following types are supertypes of Rectangle?
                1. PrintStream
                2. Shape
                3. RectangularShape
                4. Object
                5. String""", multipleAnswerQuestion1.getPrompt());
        assertEquals(3, multipleAnswerQuestion1.getCorrectAnswers().size());
        assertEquals(5, multipleAnswerQuestion1.getChoices().size());

        assertEquals("What is the cube root of 27?", questions.get(questions.size() - 1).getPrompt());
        questions.get(questions.size() - 1).setEnteredAnswer("3");
        assertEquals(1, questions.get(questions.size() - 1).checkAnswer());
    }

    @Test
    public void testAddQuestionsFromFileIncorrectFormat1() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                quiz.addQuestionsFromFile("src\\bigjavaearlyobjectsexercisesprojects\\chaptertwelve\\programmingprojects\\samplequizincorrectformat1.txt"));
        assertEquals("\"M\" or \"S\" question choices must start with \"+\" or \"-\" to indicate if the option is correct or not; line index 18.", thrown.getMessage());
    }

    @Test
    public void testAddQuestionsFromFileIncorrectFormat2() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                quiz.addQuestionsFromFile("src\\bigjavaearlyobjectsexercisesprojects\\chaptertwelve\\programmingprojects\\samplequizincorrectformat2.txt"));
        assertEquals("\"S\" questions must have a correct answer; line index 10.", thrown.getMessage());
    }

    @Test
    public void testAddQuestionsFromFileIncorrectFormat3() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                quiz.addQuestionsFromFile("src\\bigjavaearlyobjectsexercisesprojects\\chaptertwelve\\programmingprojects\\samplequizincorrectformat3.txt"));
        assertEquals("\"M\" question correct answers can't contain duplicates; line index 14.", thrown.getMessage());
    }

}
