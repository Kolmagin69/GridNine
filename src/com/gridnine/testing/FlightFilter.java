package com.gridnine.testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class FlightFilter extends Filters<Flight, Flight> {

    public FlightFilter(Predicate<Flight>... filters) {
        super(filters);
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

    private List<Flight> oneFilterList(List<Flight> flights, Predicate<Flight> filter) {
        List<Flight> filterFlights = new ArrayList<>();

       for (Flight flight : flights) {
           filterFlights.add(flight);
           if(filter.test(flight))
               filterFlights.remove(flight);

        }
        return filterFlights;
    }


}
