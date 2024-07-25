package io.github.BGPtII.ch2usingobjects;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Prints The date and weekday that is 100 days from today, the weekday of Joe's birthday (January 1, 1980)
 * and the date that is 10,000 days from Joe's birthday
 */
public class CalendarDaysAdvancementExample {
    public static void main(String[] args) {
        GregorianCalendar today = new GregorianCalendar();
        today.add(Calendar.DATE, 100);
        System.out.println("100 days from today: " + today.getTime());

        GregorianCalendar joeBirthday = new GregorianCalendar(1980, 1, 1);
        System.out.println("Joe's birthday weekday: " + joeBirthday.get(Calendar.DAY_OF_WEEK));

        joeBirthday.add(Calendar.DATE, 10000);
        System.out.println("10,000 days from Joe's birthday: " + joeBirthday.getTime());
    }
}
