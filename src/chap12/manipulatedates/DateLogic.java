package chap12.manipulatedates;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class DateLogic {

    void manipulateDates() {
        LocalDate dt1 = LocalDate.of(1990, 11, 11);
        System.out.println(dt1);

        LocalDate dt2 = dt1.withYear(2000);
        System.out.println(dt2);

        LocalDate dt3 = dt1.withMonth(4);
        System.out.println(dt3);

        LocalDate dt4 = dt1.with(ChronoField.DAY_OF_YEAR, 12);
        System.out.println(dt4);
    }

    void manipulateDatesRelative() {
        LocalDate dt1 = LocalDate.of(1990, 11, 11);
        System.out.println(dt1);

        LocalDate dt2 = dt1.plusWeeks(4);
        System.out.println(dt2);
    }

    void withTemporalAdjusters() {
        LocalDate d1 = LocalDate.of(1990, Month.NOVEMBER, 11);

        LocalDate d2 = d1.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(d2);

        LocalDate d3 = d1.with((TemporalAdjusters.lastDayOfYear()));
        System.out.println(d3);
    }

    public static void main(String[] args) {
        DateLogic dl = new DateLogic();
        //dl.manipulateDates();
        //dl.manipulateDatesRelative();
        dl.withTemporalAdjusters();
    }
}
