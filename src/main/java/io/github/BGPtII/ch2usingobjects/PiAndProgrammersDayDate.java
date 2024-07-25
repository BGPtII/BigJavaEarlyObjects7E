package io.github.BGPtII.ch2usingobjects;

import java.time.LocalDate;

/**
 * Prints the weekday of Pi day (March 14 of current year), the date + week day of
 * Programmer's day (256th day of the year) and the date + weekday that is 10,000 days
 * from today
 */
public class PiAndProgrammersDayDate {
    public static void main(String[] args) {
        LocalDate piDay = LocalDate.of(2022, 3, 14);
        System.out.println("Weekday of Pi day: " + piDay.getDayOfWeek());

        LocalDate programmerDay = LocalDate.ofYearDay(2022, 256);
        System.out.println("Programmer's day: " + programmerDay.toString() + ", " + programmerDay.getDayOfWeek());

        LocalDate today = LocalDate.now();
        today = today.plusDays(10000);
        System.out.println("10,000 days from today: " + today.toString() + ", " + today.getDayOfWeek());
    }
}
