package io.github.BGPtII.ch12objectorienteddesign.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Quiz {

    private ArrayList<Question> questions;

    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public Quiz() {
        questions = new ArrayList<>();
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addQuestions(ArrayList<Question> questionAL) {
        questions.addAll(questionAL);
    }

    public void addQuestions(Question... questionVarArgs) {
        questions.addAll(Arrays.asList(questionVarArgs));
    }

    public void removeQuestion(int index) {
        questions.remove(index);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    private void addCurrentQuestion(ArrayList<Question> questionsToAdd, String questionType, String questionPrompt, String questionCorrectAnswer, HashSet<String> questionCorrectAnswers, ArrayList<String> questionChoices, int lineIndex) {
        switch (questionType) {
            case "M" -> {
                if (questionCorrectAnswers.size() == 1) {
                    throw new IllegalArgumentException("\"M\" questions must have multiple correct answers; line index " + lineIndex + ".");
                }
                questionsToAdd.add(new MultipleAnswerChoiceQuestion(questionPrompt, questionChoices, questionCorrectAnswers));
            }
            case "S" -> {
                if (questionCorrectAnswer.isEmpty()) {
                    throw new IllegalArgumentException("\"S\" questions must have a correct answer; line index " + lineIndex + ".");
                }
                questionsToAdd.add(new SingleAnswerChoiceQuestion(questionPrompt, questionChoices, questionCorrectAnswer));
            }
            case "T" -> questionsToAdd.add(new TextQuestion(questionPrompt, questionCorrectAnswer));
            case "N" -> {
                try {
                    questionsToAdd.add(new NumberQuestion(questionPrompt, Double.parseDouble(questionCorrectAnswer)));
                }
                catch (NumberFormatException e) {
                    throw new IllegalArgumentException("\"N\" question types must be a decimal number; line index " + lineIndex + ".");
                }
            }
        }
    }

    /**
     * Refer to samplequizcorrectformat.txt for correct quiz format example
     */
    public void addQuestionsFromFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        String questionType = "";
        String questionPrompt = "";
        String questionCorrectAnswer = "";
        HashSet<String> questionCorrectAnswers = new HashSet<>();
        ArrayList<String> questionChoices = new ArrayList<>();
        int lineIndex = 0;
        try (Scanner scanner = new Scanner(file)) {
            ArrayList<Question> questionsToAdd = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (questionType.isEmpty() && !(line.equals("M") || line.equals("S") || line.equals("N") || line.equals("T"))) {
                    throw new IllegalArgumentException("Question type must be either \"T\", \"N\", \"S\" OR \"M\"; line index " + lineIndex);
                }
                else if (!line.isEmpty() && (questionType.equals("N") || questionType.equals("T")) && !questionPrompt.isEmpty() && !questionCorrectAnswer.isEmpty()) {
                    throw new IllegalArgumentException("There must be spaces between questions, line index " + lineIndex + ".");
                }
                else if (line.isEmpty()) {
                    addCurrentQuestion(questionsToAdd, questionType, questionPrompt, questionCorrectAnswer, questionCorrectAnswers, questionChoices, lineIndex);
                    questionType = "";
                    questionPrompt = "";
                    questionCorrectAnswer = "";
                    questionCorrectAnswers = new HashSet<>();
                    questionChoices = new ArrayList<>();
                }
                else if (questionType.isEmpty()) {
                    questionType = line;
                }
                else if (questionPrompt.isEmpty()) {
                    questionPrompt = line;
                }
                else {
                    if (questionType.equals("M") || questionType.equals("S")) {
                        if (line.charAt(0) != '+' && line.charAt(0) != '-') {
                            throw new IllegalArgumentException("\"M\" or \"S\" question choices must start with \"+\" or \"-\" to indicate if the option is correct or not; line index " + lineIndex + ".");
                        }
                        String lineWithoutOperator = line.substring(1).trim();
                        questionChoices.add(lineWithoutOperator);
                        if (line.charAt(0) == '+') {
                            if (questionType.equals("M")) {
                                if (!questionCorrectAnswers.add(lineWithoutOperator)) {
                                    throw new IllegalArgumentException("\"M\" question correct answers can't contain duplicates; line index " + lineIndex + ".");
                                }
                            }
                            else {
                                if (!questionCorrectAnswer.isEmpty()) {
                                    throw new IllegalArgumentException("\"S\" questions can only have one correct answer; line index " + lineIndex + ".");
                                }
                                questionCorrectAnswer = lineWithoutOperator;
                            }
                        }
                    }
                    else {
                        questionCorrectAnswer = line;
                    }
                }
                lineIndex++;
            }
            addCurrentQuestion(questionsToAdd, questionType, questionPrompt, questionCorrectAnswer, questionCorrectAnswers, questionChoices, lineIndex);
            addQuestions(questionsToAdd);
        }
    }

}
