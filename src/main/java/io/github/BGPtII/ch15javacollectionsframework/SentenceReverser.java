package io.github.BGPtII.ch15javacollectionsframework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * Prompts the user to keep inputting words until a word ends in a period, where it is printed in reverse
 */
public class SentenceReverser {

    public static void addReverseSentenceToReverseSentences(Stack<String> reversedWords, ArrayList<String> reversedSentences) {
        StringBuilder reversedSentence = new StringBuilder();
        String firstWord = reversedWords.pop();
        firstWord = firstWord.substring(0, 1).toUpperCase() + firstWord.substring(1);
        reversedSentence.append(firstWord);
        Iterator<String> iterator = reversedWords.iterator();
        while (iterator.hasNext()) {
            reversedSentence.append(" ").append(reversedWords.pop());
        }
        reversedSentence.append(".");
        reversedSentences.add(reversedSentence.toString());
    }

    public static void main(String[] args) {
        Stack<String> reversedWords = new Stack<>();
        ArrayList<String> reversedSentences = new ArrayList<>();
        System.out.println("Sentence Reverser (\"::x\" to finish/exit application)");
        System.out.println("\".\" symbolizes the end of a sentence; after this is reached, the sentence is printed in reverse order.");
        System.out.println("Keep entering words, does not accept blank entries though!");
        System.out.println("If the application is prematurely exited before the end of a sentence is reached, uses what it...");
        System.out.println("currently has, as the sentence to reverse.");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String line = scanner.nextLine().trim().toLowerCase();
                if (line.equals("::x")) {
                    if (!reversedWords.isEmpty()) {
                        addReverseSentenceToReverseSentences(reversedWords, reversedSentences);
                    }
                    for (String reversedSentence : reversedSentences) {
                        System.out.print(reversedSentence + " ");
                    }
                    break;
                }
                else if (!line.isEmpty()) {
                    if (line.charAt(line.length() - 1) == '.') {
                        reversedWords.add(line.substring(0, line.length() - 1));
                        addReverseSentenceToReverseSentences(reversedWords, reversedSentences);
                    }
                    else {
                        reversedWords.add(line);
                    }
                }
            }
        }
    }

}
