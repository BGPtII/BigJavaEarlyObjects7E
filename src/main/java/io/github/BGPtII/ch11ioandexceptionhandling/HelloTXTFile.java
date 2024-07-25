package io.github.BGPtII.ch11ioandexceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Opens a file with the name hello.txt, stores "Hello, World!" in it, then reads it
 */
public class HelloTXTFile {

    public static void main(String[] args) {
        File helloFile = new File("src/bigjavaearlyobjectsexercisesprojects/chaptereleven/practiceexercises/hello.txt");
        try (PrintWriter output = new PrintWriter(helloFile)) {
            output.println("Hello, World!");
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Can't find file.");
        }
        try (Scanner scanner = new Scanner(helloFile)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Can't find file.");
        }
    }

}
