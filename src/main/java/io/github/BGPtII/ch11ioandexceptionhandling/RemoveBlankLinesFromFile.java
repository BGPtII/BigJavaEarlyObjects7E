package io.github.BGPtII.ch11ioandexceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Reads a text file, removes any blank lines, writes the non-blank lines back to the same file
 */
public class RemoveBlankLinesFromFile {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File fileToModify = null;
        while (fileToModify == null) {
            System.out.print("Enter file name (& directory if not local - 'q' to quit): ");
            if (input.hasNext("q")) {
                System.out.println("Quitting...");
                System.exit(0);
            }
            fileToModify = new File(input.next());
            if (!fileToModify.exists() || !fileToModify.isFile()) {
                System.out.println("File not found or not a valid file. Please enter a valid file name (& location).");
                fileToModify = null;
            }
        }
        input.close();
        System.out.println("File selected: " + fileToModify.getAbsolutePath());

        try (Scanner fileReader = new Scanner(fileToModify)) {
            StringBuilder contentBuilder = new StringBuilder();
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (!line.trim().isEmpty()) {
                    contentBuilder.append(line).append("\n");
                }
            }
            try (PrintWriter output = new PrintWriter(fileToModify)) {
                output.print(contentBuilder);
            }
            System.out.println("Blank lines removed & file updated successfully.");
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found.");
        }
    }
}
