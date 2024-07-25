package io.github.BGPtII.ch11ioandexceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Store transactions file format: "invoiceNumber cashAmount P/R" (P if paid, R if received).
 * Prompts the store owner for the value of the cash in the till at the beginning of the day, end of the day, and the
 * day's transaction file.
 * Checks whether the actual total at the end of the day (from the transaction file) matches the expected value.
 */
public class StoreTransactions {

    public static void main(String[] args) {
        double tillCashValueStarting = -1;
        double tillCashValueEndingExpected = -1;
        File transactionTextFile = null;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the needed values ('q' to quit at any prompt)...");
        while (tillCashValueStarting <= 0 || tillCashValueEndingExpected <= 0 || transactionTextFile == null) {
            if (tillCashValueStarting <= 0) {
                System.out.print("Enter the till's total cash value at the start of the day: ");
                if (input.hasNext("q")) {
                    System.out.println("Quitting...");
                    input.close();
                    System.exit(0);
                }
                else if (input.hasNextDouble()) {
                    tillCashValueStarting = input.nextDouble();
                    if (tillCashValueStarting <= 0) {
                        System.out.println("Value can't be less than or equal to 0.");
                    }
                }
                else {
                    System.out.println("Only numbers are valid.");
                    input.next();
                }
            }
            else if (tillCashValueEndingExpected <= 0) {
                System.out.print("Enter the expected till's total cash value at the end of the day: ");
                if (input.hasNext("q")) {
                    System.out.println("Quitting...");
                    input.close();
                    System.exit(0);
                }
                else if (input.hasNextDouble()) {
                    tillCashValueEndingExpected = input.nextDouble();
                    if (tillCashValueEndingExpected <= 0) {
                        System.out.println("Value can't be less than or equal to 0.");
                    }
                }
                else {
                    System.out.println("Only numbers are valid.");
                    input.next();
                }
            }
            else {
                System.out.print("Enter the directory & .txt file path for the daily till transaction records: ");
                String filePath = input.next();
                if (filePath.equals("q")) {
                    System.out.println("Quitting...");
                    input.close();
                    System.exit(0);
                }
                if (filePath.endsWith(".txt")) {
                    transactionTextFile = new File(filePath);
                    try (Scanner fileScanner = new Scanner(transactionTextFile)) { }
                    catch (FileNotFoundException fileNotFoundException) {
                        System.out.println("Can't find the file at the specified location.");
                        transactionTextFile = null;
                    }
                }
                else {
                    System.out.println("Transaction records must end in .txt.");
                }
            }
        }
        input.close();

        try (Scanner fileScanner = new Scanner(transactionTextFile)) {
            int lineIndex = 0;
            double tillCashValueEndingActual = tillCashValueStarting;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] fields = line.split("\\s+");
                if (fields.length != 3) {
                    System.out.println("Invalid transaction file format at line index " + lineIndex + ".");
                    System.out.println("Can't accurately parse data, quitting...");
                    System.exit(0);
                }
                else {
                    try {
                        Integer.parseInt(fields[0]);
                        double transactionValue = Double.parseDouble(fields[1]);
                        if (fields[2].equals("P") || fields[2].equals("R")) {
                            if (fields[2].equals("P")) {
                                tillCashValueEndingActual -= transactionValue;
                                System.out.println("paying " + transactionValue);
                            }
                            else {
                                tillCashValueEndingActual += transactionValue;
                                System.out.println("receiving " + transactionValue);
                            }
                        }
                        else {
                            System.out.println("Transaction must either be P for paid or R for received; line index " + lineIndex + ".");
                            System.out.println("Can't accurately interpret data, quitting...");
                            System.exit(0);
                        }
                    }
                    catch (NumberFormatException numberFormatException) {
                        System.out.println("Can't parse invoice number & transaction value at line index " + lineIndex + ".");
                        System.out.println("Can't accurately interpret data, quitting...");
                        System.exit(0);
                    }
                }
                lineIndex++;
            }
            System.out.println("Expected till total cash value at the end of the day: " + tillCashValueEndingExpected);
            System.out.println("Actual till total cash value at the end of the day: " + tillCashValueEndingActual);
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Can't find the file at the specified location.");
        }
    }

}
