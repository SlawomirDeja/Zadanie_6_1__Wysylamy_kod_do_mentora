package com.kodilla.exception.test;

public class FlightFinderRunner {

    public static void main(String[] args) {

        FlightFinder flightFinder = new FlightFinder();

        try {
            flightFinder.findFlight(new Flight("aiportname10", "airportname2"));

        } catch (RouteNotFoundException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("Processing other logic!");
    }
}
