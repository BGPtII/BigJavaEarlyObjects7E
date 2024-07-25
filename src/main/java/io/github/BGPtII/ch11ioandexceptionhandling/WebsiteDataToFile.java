package io.github.BGPtII.ch11ioandexceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Reads all data from a web page and writes it to a file
 */
public class WebsiteDataToFile {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner pageInput = null;
        URL pageLocation = null;
        while (pageLocation == null) {
            System.out.print("Enter the URL string of the webpage you want in a file ('q' to quit): ");
            if (input.hasNext("q")) {
                System.out.println("Quitting...");
                input.close();
                System.exit(0);
            }
            String address = input.next().trim();
            try {
                pageLocation = new URL(address);
                pageInput = new Scanner(pageLocation.openStream());
            }
            catch (MalformedURLException malformedURLException) {
                System.out.println("Invalid URL format.");
                pageLocation = null;
            }
            catch (IOException ioException) {
                System.out.println("Error connecting to or reading from the URL.");
                pageLocation = null;
            }
        }

        File outputFile = null;
        while (outputFile == null) {
                System.out.print("Enter output file name (& directory if not local - 'q' to quit): ");
                if (input.hasNext("q")) {
                    System.out.println("Quitting...");
                    input.close();
                    System.exit(0);
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

        input.close();

        try (PrintWriter output = new PrintWriter(outputFile)) {
            while (pageInput.hasNextLine()) {
                String line = pageInput.nextLine();
                output.println(line);
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error writing to the output file.");
        }

        System.out.println("Successfully created website data file at: " + outputFile.getAbsolutePath() + ".");
        pageInput.close();
    }

}
