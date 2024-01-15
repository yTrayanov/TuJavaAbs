package com.tujava.tujava.services;
import com.tujava.tujava.models.Airport;
import com.tujava.tujava.repositories.AirportRepository;
import com.tujava.tujava.utils.constants.ModelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public void CreateAirport(String airportName){

        if(airportName.length() != ModelConstants.AIRPORT_NAME_LENGTH ){
            throw new ExpressionException("Airport name should have length of 3 and contain only CAPITAL letters");
        }

        Airport airport = new Airport(airportName);
        airportRepository.save(airport);
    }

    public Airport getAirportByName(String airportName){
        Optional<Airport> airport = airportRepository.findByName(airportName);

        if(airport.isEmpty()){
            throw new ExpressionException("Airport not found");
        }

        return airport.get();
    }
}
