package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

public class IsTimeOnEarthOverTwoHour implements Predicate<Flight> {

    @Override
    public boolean test(Flight flight) {
        final List<Segment> segments = flight.getSegments();
        long time = 0;
        for (int i = 0; i < segments.size() - 1; i++) {
            LocalDateTime arrival = segments.get(i).getArrivalDate();
            LocalDateTime departure = segments.get(i + 1).getDepartureDate();
            time += LocalDateTimeUtil.dateDifferenceSecond(arrival, departure);
            if(time > 7200)
                return true;
        }
        return false;
    }

}
