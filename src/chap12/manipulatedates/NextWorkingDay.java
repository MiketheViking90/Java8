package chap12.manipulatedates;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextWorkingDay implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));

        if (dow.equals(DayOfWeek.FRIDAY)) {
            return temporal.plus(3, ChronoUnit.DAYS);
        } else if (dow.equals(DayOfWeek.SATURDAY)) {
            return temporal.plus(2, ChronoUnit.DAYS);
        } else {
            return temporal.plus(1, ChronoUnit.DAYS);
        }
    }

}
