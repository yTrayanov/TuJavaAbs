package com.tujava.tujava.dto;

import java.time.LocalDate;

public class FlightCreateUpdateDto {

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getLandingAirport() {
        return landingAirport;
    }

    public String getAirline() {
        return airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalDate getLandingDate() {
        return landingDate;
    }

    private String departureAirport;
    private String landingAirport;
    private String airline;

    private String flightNumber;

    private LocalDate departureDate;

    private LocalDate landingDate;

}
