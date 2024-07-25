package io.github.BGPtII.ch1introduction;

/**
 * Prints a 2-column list of birthdays
 */
public class PrintBirthdayTable {
    public static void main(String[] args) {
        System.out.printf("%-10s %15s", "Name", "Birthday\n");
        System.out.print("-------------------------\n");
        System.out.printf("%-10s %15s", "Bob", "07/14/1998\n");
        System.out.printf("%-10s %15s", "Dave", "04/14/1995\n");
        System.out.printf("%-10s %15s", "Joe", "01/06/1990\n");
    }
}
