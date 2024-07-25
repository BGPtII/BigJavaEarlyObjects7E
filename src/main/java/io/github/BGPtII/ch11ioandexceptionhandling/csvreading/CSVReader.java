package io.github.BGPtII.ch11ioandexceptionhandling.csvreading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Reads & analyzes a .csv file
 * .csv file format EX: 1729, San Francisco, "Hello, World", "He asked: ""Quo vadis?"""
 */
public class CSVReader {

    private File csvFile;
    private Pattern csvFieldPattern;

    public CSVReader(String filePath) {
        if (!filePath.endsWith(".csv")) {
            throw new IllegalArgumentException("File must be a .csv file.");
        }
        csvFile = new File(filePath);
        csvFieldPattern = Pattern.compile(",(?=(?:[^\"]*\"[^\"]*\")*(?![^\"]*\"))");
        try (Scanner csvScanner = new Scanner(csvFile)) {
            if (!csvScanner.hasNextLine()) {
                throw new IllegalArgumentException("File can't be empty.");
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            throw new IllegalArgumentException("File can't be found at the specified filePath.");
        }
    }

    public int getTotalRowCount() throws FileNotFoundException {
        int rowCount = 0;
        try (Scanner csvScanner = new Scanner(csvFile)) {
            while (csvScanner.hasNextLine()) {
                csvScanner.nextLine();
                rowCount++;
            }
        }
        return rowCount;
    }

    /**
     * rowIndex follows standard indexing format - starts at 0
     */
    public String getRowAsString(int rowIndex) throws FileNotFoundException {
        if (rowIndex < 0) {
            throw new IllegalArgumentException("rowIndex must be 0 or greater.");
        }
        try (Scanner csvScanner = new Scanner(csvFile)) {
            int currentRowIndex = 0;
            while (csvScanner.hasNextLine()) {
                String line = csvScanner.nextLine();
                if (currentRowIndex == rowIndex) {
                    return line;
                }
                currentRowIndex++;
            }
            throw new IllegalArgumentException("rowIndex exceeds the number of rows in the file.");
        }
    }

    public int getNumberOfFieldsForRow(int rowIndex) throws FileNotFoundException {
        if (rowIndex < 0) {
            throw new IllegalArgumentException("rowIndex must be 0 or greater.");
        }
        try (Scanner csvScanner = new Scanner(csvFile)) {
            int currentRowIndex = 0;
            while (csvScanner.hasNextLine()) {
                String line = csvScanner.nextLine();
                if (currentRowIndex == rowIndex) {
                    if (line.trim().isEmpty()) {
                        return 0;
                    }
                    return csvFieldPattern.split(line).length;
                }
                currentRowIndex++;
            }
            throw new IllegalArgumentException("rowIndex exceeds the number of rows in the file.");
        }
    }

    public String getFieldData(int rowIndex, int columnIndex) throws FileNotFoundException {
        if (rowIndex < 0 || columnIndex < 0) {
            throw new IllegalArgumentException("rowIndex && columnIndex must be 0 or greater.");
        }
        try (Scanner csvScanner = new Scanner(csvFile)) {
            int currentRowIndex = 0;
            while (csvScanner.hasNextLine()) {
                String line = csvScanner.nextLine();
                if (currentRowIndex == rowIndex) {
                    String[] fields = csvFieldPattern.split(line);
                    if (fields.length <= columnIndex) {
                        throw new IllegalArgumentException("columnIndex exceeds the number of columns in the file.");
                    }
                    return fields[columnIndex];
                }
                currentRowIndex++;
            }
            throw new IllegalArgumentException("rowIndex exceeds the number of rows in the file.");
        }
    }

    public String[] getColumnFields(int columnIndex) throws FileNotFoundException {
        if (columnIndex < 0) {
            throw new IllegalArgumentException("columnIndex must be 0 or greater.");
        }
        try (Scanner csvScanner = new Scanner(csvFile)) {
            return csvScanner.useDelimiter("\n")
                    .tokens()
                    .map(line -> {
                        String[] fields = csvFieldPattern.split(line);
                        if (fields.length <= columnIndex) {
                            throw new IllegalArgumentException("ColumnIndex exceeds the amount of fields on the line.");
                        }
                        return fields[columnIndex];
                    })
                    .toArray(String[]::new);
        }
    }

    public HashMap<String, Integer> getColumnFieldHistogram(int columnIndex) throws FileNotFoundException {
        if (columnIndex < 0) {
            throw new IllegalArgumentException("columnIndex must be 0 or greater.");
        }
        HashMap<String, Integer> histogram = new HashMap<>();
        try (Scanner csvScanner = new Scanner(csvFile)) {
            while (csvScanner.hasNextLine()) {
                String[] fields = csvFieldPattern.split(csvScanner.nextLine());
                if (fields.length <= columnIndex) {
                    throw new IllegalArgumentException("columnIndex exceeds the amount of fields on the line.");
                }
                String key = fields[columnIndex];
                histogram.put(key, histogram.getOrDefault(key, 0) + 1);
            }
        }
        return histogram;
    }

    public double columnAverage(int columnIndex, boolean skipUnparsableRows) throws FileNotFoundException {
        double sum = 0;
        int count = 0;
        try (Scanner csvScanner = new Scanner(csvFile)) {
            while (csvScanner.hasNextLine()) {
                String[] fields = csvFieldPattern.split(csvScanner.nextLine());
                if (fields.length <= columnIndex) {
                    throw new IllegalArgumentException("columnIndex exceeds the amount of fields on the line.");
                }
                try {
                    sum += Double.parseDouble(fields[columnIndex]);
                    count++;
                }
                catch (NumberFormatException numberFormatException) {
                    if (!skipUnparsableRows) {
                        throw new NumberFormatException("Non-numeric value found at columnIndex on the line, cannot parse as double.");
                    }
                }
            }
        }
        return (count == 0) ? 0 : sum / count;
    }

}
