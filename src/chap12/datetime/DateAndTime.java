package chap12.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class DateAndTime {

    void useLocalDate() {
        LocalDate date = LocalDate.of(1990, 11, 11);
        int year = date.getYear();
        DayOfWeek dow = date.getDayOfWeek();
        Month month = date.getMonth();
        int monthLength = date.lengthOfMonth();
        boolean isLeapYear = date.isLeapYear();
    }

    void temporalFieldStrategy() {
        LocalDate date = LocalDate.of(1990, 11, 11);
        int year = date.get(ChronoField.YEAR);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
    }

    void useLocalTime() {
        LocalTime time = LocalTime.of(14, 12);
        System.out.println(time);
    }

    void localDateTimeParsing() {
        LocalDate date = LocalDate.parse("1990-11-11");
        LocalTime time = LocalTime.parse("14:02:12");
    }

    public static void main(String[] args) {
        DateAndTime dt = new DateAndTime();

        LocalDate date = LocalDate.of(1990, 11, 11);
        System.out.println(date);

        dt.useLocalTime();
        dt.localDateTimeParsing();
    }

}
