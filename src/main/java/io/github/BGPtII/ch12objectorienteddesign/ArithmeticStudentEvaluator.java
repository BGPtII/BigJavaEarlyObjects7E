package io.github.BGPtII.ch12objectorienteddesign;

import java.util.Random;
import java.util.Scanner;

/**
 * Teaches arithmetic using a tier-based design: tier 1 tests only addition of numbers less than ten whose sum
 * is less than ten; tier 2 tests addition of arbitrary one-digit numbers; tier 3 tests subtraction of one-digit
 * numbers with a non-negative difference.
 * The question's numbers are randomly generated.
 * The player gets 2 tries per question, & an advancement to a higher tier is made when a player gets 5 points.
 */
public class ArithmeticStudentEvaluator {

    public static void main(String[] args) {
        boolean runEvaluator = true;
        int tier = 1;
        int triesLeft = 2;
        int points = 0;
        Random randomGenerator = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("Arithmetic Evaluator ('q' to quit at any time)");
        int x = 0;
        int y = 0;
        int correctAnswer = 0;
        String operator = " ";
        while (true) {
            if (triesLeft == 2) {
                if (tier == 1) {
                    do {
                        x = randomGenerator.nextInt(10);
                        y = randomGenerator.nextInt(10);
                    }
                    while (x + y >= 10);
                    correctAnswer = x + y;
                    operator = "+";
                }
                else if (tier == 2) {
                    x = randomGenerator.nextInt(10);
                    y = randomGenerator.nextInt(10);
                    correctAnswer = x + y;
                    operator = "+";
                }
                else {
                    do {
                        x = randomGenerator.nextInt(10);
                        y = randomGenerator.nextInt(10);
                    }
                    while (x - y < 0);
                    correctAnswer = x - y;
                    operator = "-";
                }
            }

            System.out.print("Answer: " + x + " " + operator + " " + y + " = ");
            String response = input.nextLine();

            if (response.equals("q")) {
                System.out.println("Quitting...");
                break;
            }

            try {
                int answer = Integer.parseInt(response);
                if (answer == correctAnswer) {
                    points++;
                    if (points == 5 && tier != 3) {
                        tier++;
                        points = 0;
                        triesLeft = 2;
                    }
                    System.out.println("Correct! Current tier: " + tier + ", current points: " + points + ".");
                }
                else {
                    triesLeft--;
                    if (triesLeft < 0) {
                        triesLeft = 2;
                    }
                    System.out.println("Incorrect! Tries left: " + triesLeft + ".");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Only whole numbers allowed as an answer, try again (tries left: " + triesLeft + ").");
                triesLeft--;
                if (triesLeft < 0) {
                    triesLeft = 2;
                }
            }
        }
    }
}
