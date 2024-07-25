package io.github.BGPtII.ch15javacollectionsframework;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 * Prompts the user to add student names with their associated grades (B+, A-, F, D format); keeps track
 * of the grades in a HashMap, and prints them out in lexicographic order
 */
public class StudentGrades {

    private static TreeMap<String, String> studentNameToGrade = new TreeMap<>();
    private static Pattern gradeLetterPattern = Pattern.compile("^[A-D][+-]?|F$");

    public static void main(String[] args) {
        String name = "";
        String grade = "";
        System.out.println("Add Student Names & Their Grades (\"q\" to quit)");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                if (name.isEmpty()) {
                    System.out.print("Enter student's name: ");
                    String line = scanner.nextLine().trim();
                    if (line.equalsIgnoreCase("q")) {
                        System.out.println("Quitting...");
                        break;
                    }
                    else if (line.isEmpty()) {
                        System.out.println("Student's last name can't be empty.");
                    }
                    else {
                        name = line;
                    }
                }
                else if (grade.isEmpty()) {
                    System.out.print("Enter their current letter grade: ");
                    String line = scanner.nextLine().trim();
                    if (line.equalsIgnoreCase("q")) {
                        System.out.println("Quitting...");
                        break;
                    }
                    else if (gradeLetterPattern.matcher(line).matches()) {
                        grade = line;
                    }
                    else {
                        System.out.println("Grade Letter must follow the pattern: A-D(+/-) or just an F.");
                    }
                }
                else {
                    studentNameToGrade.put(name, grade);
                    System.out.println("Added " + name + " with grade " + grade + ".");
                    name = "";
                    grade = "";
                }
            }
            if (studentNameToGrade.isEmpty()) {
                System.out.println("Student names to grades does not contain any entries.");
            }
            else {
                for (String studentName : studentNameToGrade.keySet()) {
                    System.out.println(studentName + ": " + studentNameToGrade.get(studentName));
                }
            }
        }
    }

}
