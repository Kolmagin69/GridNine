package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SegmentFilter extends Filters<Flight, Segment> {

    public SegmentFilter(Predicate<Segment>... filter1) {
        super(filter1);
    }

    @Override
    public List<List<Flight>> filterList(List<Flight> flights) {
        final List<List<Flight>> result = new ArrayList<>();

        if(filters.length == 0 || filters == null) {
            result.add(flights);
            return result;
        }
        for (int i = 0; i < filters.length; i++) {
            result.add(oneFilterList(flights, filters[i]));
        }
        return result;
    }

    private List<Flight> oneFilterList(List<Flight> flights, Predicate<Segment> filter) {
        List<Flight> filterFlights = new ArrayList<>();

       for (Flight flight : flights) {
           filterFlights.add(flight);
           for (Segment segment : flight.getSegments()) {
                if (filter.test(segment))
                    filterFlights.remove(flight);
            }
        }
        return filterFlights;
    }


}
