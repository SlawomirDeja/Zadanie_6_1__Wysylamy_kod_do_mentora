package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public void findFlight(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> airportsAndTheirAvailability = new HashMap<>();
        airportsAndTheirAvailability.put("airportname1", true);
        airportsAndTheirAvailability.put("airportname2", true);
        airportsAndTheirAvailability.put("airportname3", false);
        airportsAndTheirAvailability.put("airportname4", false);
        airportsAndTheirAvailability.put("airportname5", true);

        if (airportsAndTheirAvailability.containsKey(flight.getArrivalAirport())) {
            System.out.println("The flight is available");
        } else {
            throw new RouteNotFoundException("Airport not found");
        }
    }
}
