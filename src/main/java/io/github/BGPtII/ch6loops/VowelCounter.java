package io.github.BGPtII.ch6loops;

import java.util.Scanner;

public class VowelCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vowelCount = 0;
        System.out.print("Enter a word or sentence: ");
        String input = scanner.nextLine().toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case 'a', 'e', 'i', 'o', 'u' -> vowelCount++;
                default -> { }
            }
        }
        System.out.println("Total vowel count: " + vowelCount);
    }
}
