package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    private Map<String, Boolean> airportsAndTheirAvailability = new HashMap<>();

    public FlightFinder() {

        airportsAndTheirAvailability.put("airportname1", true);
        airportsAndTheirAvailability.put("airportname2", true);
        airportsAndTheirAvailability.put("airportname3", false);
        airportsAndTheirAvailability.put("airportname4", false);
        airportsAndTheirAvailability.put("airportname5", true);
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {

        Boolean result = airportsAndTheirAvailability.get(flight.getArrivalAirport());

        if (result == null || !result) {

            throw new RouteNotFoundException("Route not found");

        } else {

            System.out.println("The flight is available");
        }
    }
}
