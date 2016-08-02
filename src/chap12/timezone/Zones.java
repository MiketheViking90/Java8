package chap12.timezone;

import java.time.ZoneId;
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

    public static void main(String[] args) {
        Zones zones = new Zones();
        zones.createTimeZone();
    }

}
