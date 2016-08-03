package chap12.timezone;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRules;
import java.util.TimeZone;

public class Zones {

    void createTimeZone() {
        ZoneId zone = ZoneId.of("America/Louisville");
        System.out.println(zone);

        ZoneRules losAngelesRules = zone.getRules();
        System.out.println(losAngelesRules);

        ZoneId defaultTzToZone= TimeZone.getDefault().toZoneId();
        System.out.println(TimeZone.getDefault());
        System.out.println(defaultTzToZone);
    }

    void applyZoneId() {
        ZoneId zone = ZoneId.systemDefault();
        LocalDate dt = LocalDate.of(1990, Month.NOVEMBER, 11);
        ZonedDateTime zdt1 = dt.atStartOfDay(zone);
        System.out.println(zdt1);

        Instant now = Instant.now();
        ZonedDateTime zdt2 = now.atZone(zone);
        System.out.println(zdt2);
    }

    public static void main(String[] args) {
        Zones zones = new Zones();
        zones.createTimeZone();
        System.out.println();

        zones.applyZoneId();
    }

}
