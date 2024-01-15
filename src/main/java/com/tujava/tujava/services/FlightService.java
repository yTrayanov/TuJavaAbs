package com.tujava.tujava.services;

import com.tujava.tujava.dto.FlightCreateUpdateDto;
import com.tujava.tujava.dto.FlightGetDto;
import com.tujava.tujava.models.*;
import com.tujava.tujava.repositories.FlightRepository;
import com.tujava.tujava.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AirportService airportService;

   @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private SeatService seatService;


    public void CreateFlight(FlightCreateUpdateDto flightInfo){

        Airport departureAirport = airportService.getAirportByName(flightInfo.getDepartureAirport());
        Airport arrivalAirport = airportService.getAirportByName(flightInfo.getLandingAirport());
        Airline airline = airlineService.getAirportByName(flightInfo.getAirline());


        Flight flight = new Flight(flightInfo.getFlightNumber(), airline, departureAirport ,arrivalAirport ,flightInfo.getDepartureDate(), flightInfo.getLandingDate());

        flightRepository.save(flight);
    }

    public void DeleteFlight(String flightNumber){
        Optional<Flight> flight = flightRepository.findByFlightNumber(flightNumber);

        if(flight.isEmpty()){
            throw new ExpressionException("Flight not found");
        }

        flightRepository.delete(flight.get());
    }

    public Flight UpdateFlight(FlightCreateUpdateDto flightInfo){
        Flight flight = GetFlightByFlightNumber(flightInfo.getFlightNumber());

        if(flightInfo.getDepartureAirport() != flight.getDepartureAirport().getName()){
            Airport departureAirport = airportService.getAirportByName(flightInfo.getDepartureAirport());
            flight.setDepartureAirport(departureAirport);
        }

        if(flightInfo.getLandingAirport() != flight.getArrivalAirport().getName()){
            Airport arrivalAirport = airportService.getAirportByName(flightInfo.getLandingAirport());
            flight.setArrivalAirport(arrivalAirport);
        }

        if(flightInfo.getAirline() != flight.getAirline().getName()){
            Airline airline = airlineService.getAirportByName(flightInfo.getAirline());
            flight.setAirline(airline);
        }

        flight.setDepartureDate(flightInfo.getDepartureDate());
        flight.setLandingDate(flightInfo.getLandingDate());

        flightRepository.save(flight);

        return flight;

   }
   public Flight GetFlightByFlightNumber(String flightNumber){
        Optional<Flight> flight = flightRepository.findByFlightNumber(flightNumber);

        if(flight.isEmpty()){
            throw new ExpressionException("Flight not found");
        }

        return flight.get();
   }

   public FlightGetDto GetFlight(String flightNumber){
        Flight flight = GetFlightByFlightNumber(flightNumber);

        FlightGetDto flightDto = new FlightGetDto();
        flightDto.setFlight(flight);

        Optional<List<Section>> sectionsOptional = sectionRepository.findSectionsByFlight(flight);

        if(sectionsOptional.isEmpty()){
            return flightDto;
        }


        List<Section> sections = sectionsOptional.get();
        flightDto.setSections(sections);

       Map<SeatClass , List<Seat>> seats = new HashMap<>();

       for (Section section: sections) {
           List<Seat> sectionSeats = seatService.GetSeatsBySection(section);
           seats.put(section.seatClass , sectionSeats);
       }

       flightDto.setSeats(seats);


       return flightDto;

   }

}