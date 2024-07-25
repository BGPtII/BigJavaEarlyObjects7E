package io.github.BGPtII.ch11ioandexceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// Reads a text file, sends each line to a new file that indicates line numbers through the format:
//  * "/* lineNumber */"  - uses the delimiters for use in Java source files
public class AddLineNumbersToFile {

    private static void exitProgramCloseScanner(Scanner scanner) {
        System.out.println("Quitting...");
        scanner.close();
        System.exit(0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File inputFile = null;
        File outputFile = null;
        while (inputFile == null || outputFile == null) {
            if (inputFile == null) {
                System.out.print("Enter input file name (& directory if not local - 'q' to quit): ");
                if (input.hasNext("q")) {
                    exitProgramCloseScanner(input);
                }
                inputFile = new File(input.next());
                if (!inputFile.exists() || !inputFile.isFile()) {
                    System.out.println("File not found or not a valid file. Please enter a valid file name (& location).");
                    inputFile = null;
                }
            }
            else {
                System.out.print("Enter output file name (& directory if not local - 'q' to quit): ");
                if (input.hasNext("q")) {
                    exitProgramCloseScanner(input);
                }
                try {
                    outputFile = new File(input.next());
                    if (outputFile.exists()) {
                        System.out.println("Output file already exists. It will be overwritten.");
                    }
                    else if (!outputFile.createNewFile()) {
                        System.out.println("Cannot create the output file with the specified name/directory.");
                        outputFile = null;
                    }
                }
                catch (IOException ioException) {
                    System.out.println("Cannot create the output file with the specified name/directory.");
                    outputFile = null;
                }
            }
        }
        input.close();
        System.out.println("Input file selected: " + inputFile.getAbsolutePath());
        System.out.println("Output file selected: " + outputFile.getAbsolutePath());

        try (Scanner fileReader = new Scanner(inputFile)) {
            StringBuilder contentBuilder = new StringBuilder();
            int lineNumber = 1;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                contentBuilder.append("/* ").append(lineNumber).append("*/ ").append(line).append("\n");
            }
            try (PrintWriter output = new PrintWriter(outputFile)) {
                output.print(contentBuilder);
            }
            System.out.println("Added line number indications successfully.");
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found.");
        }
    }
}
