package com.tujava.tujava.services;
import com.tujava.tujava.models.Airport;
import com.tujava.tujava.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public void CreateAirport(String airportName){
        Airport airport = new Airport(airportName);

        airportRepository.save(airport);
    }

    public Airport getAirportByName(String airportName){
        Optional<Airport> airport = airportRepository.findByName(airportName);

        return airport.orElse(null);
    }
}
