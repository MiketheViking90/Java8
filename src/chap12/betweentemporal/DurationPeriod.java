package chap12.betweentemporal;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;

public class DurationPeriod {

    void createDurations() {
        LocalDateTime dt1 = LocalDateTime.of(1990, Month.NOVEMBER, 11, 2, 14);
        LocalDateTime dt2 = LocalDateTime.of(1990, Month.NOVEMBER, 11, 3, 15);
        Duration dur1 = Duration.between(dt1, dt2);
        System.out.println(dur1);
    }

    void createPeriods() {
        LocalDate d1 = LocalDate.of(1984, 4, 30);
        LocalDate d2 = LocalDate.of(2017, 2, 12);

        Period pd1 = Period.between(d1, d2);
        System.out.println(pd1);
    }

    public static void main(String[] args) {
        DurationPeriod dpd = new DurationPeriod();
        dpd.createDurations();
        dpd.createPeriods();
    }

}
