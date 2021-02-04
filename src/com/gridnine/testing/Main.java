package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        FilterFlightController flightController = new FilterFlightController();

        List<Flight> flightsList = FlightBuilder.createFlights();
        for (Flight flight : flightsList) {
            System.out.println(flight.toString());
        }
        System.out.println("\n");

        Filters segmentFilter = new SegmentFilter (
                (segment -> segment.getDepartureDate().isAfter(segment.getArrivalDate())),
                (segment -> segment.getDepartureDate().isBefore(LocalDateTime.now()))
        );

        Filters flightFilter = new FlightFilter(new IsTimeOnEarthOverTwoHour());


        List<List<Flight>> flightsListFiltered = flightController.filterList(flightsList, segmentFilter, flightFilter);

        for (List<Flight> flightsListForeach: flightsListFiltered) {
            for (Flight flight : flightsListForeach) {
                System.out.println(flight.toString());
            }
            System.out.println("\n");
        }
    }

}



