package com.tujava.tujava.services;

import com.tujava.tujava.models.Airline;
import com.tujava.tujava.repositories.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    public void CreateAirline(String airlineName){
        Airline airline  = new Airline(airlineName);

        airlineRepository.save(airline);
    }

    public Airline getAirportByName(String airportName){
        Optional<Airline> airline = airlineRepository.findByName(airportName);

        return airline.orElse(null);
    }
}
