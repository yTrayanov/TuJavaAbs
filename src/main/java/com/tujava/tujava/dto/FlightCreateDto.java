package com.tujava.tujava.dto;

import java.util.Date;

public class FlightCreateDto {

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

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getLandingDate() {
        return landingDate;
    }

    private String departureAirport;
    private String landingAirport;
    private String airline;

    private String flightNumber;

    private Date departureDate;

    private Date landingDate;

}
