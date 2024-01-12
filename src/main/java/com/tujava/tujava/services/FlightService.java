package com.tujava.tujava.services;

import com.tujava.tujava.dto.FlightCreateDto;
import com.tujava.tujava.models.Airline;
import com.tujava.tujava.models.Airport;
import com.tujava.tujava.models.Flight;
import com.tujava.tujava.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AirportService airportService;

    public void CreateFlight(FlightCreateDto flightInfo){

        Airport departureAirport = airportService.getAirportByName(flightInfo.getDepartureAirport());
        Airport arrivalAirport = airportService.getAirportByName(flightInfo.getLandingAirport());
        Airline airline = airlineService.getAirportByName(flightInfo.getAirline());


        Flight flight = new Flight(flightInfo.getFlightNumber(), airline, departureAirport ,arrivalAirport ,flightInfo.getDepartureDate(), flightInfo.getLandingDate());

        flightRepository.save(flight);
    }

    public void DeleteFlight(String flightNumber){
        Optional<Flight> flight = flightRepository.findByFlightNumber(flightNumber);

        flight.ifPresent(value -> flightRepository.delete(value));
    }

//    public Flight UpdateFlight(FlightCreateDto flightInfo){
//        Optional<Flight> flight = flightRepository.findByFlightNumber(flightInfo.getFlightNumber());
//        Airport departureAirport = airportService.getAirportByName(flightInfo.getDepartureAirport());
//
//        if(flight.isPresent()){
//
//        }
//    }
}

// user controller, create user , delete user , get user with create flights , flight CRUD , flight model to have createdBy,