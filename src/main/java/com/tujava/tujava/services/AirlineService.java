package com.tujava.tujava.services;

import com.tujava.tujava.models.Airline;
import com.tujava.tujava.repositories.AirlineRepository;
import com.tujava.tujava.utils.constants.ModelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    public void CreateAirline(String airlineName){

        if(airlineName.length() > ModelConstants.AIRLINE_NAME_MAX_LENGTH || airlineName.length() == 0){
            throw new ExpressionException("AirlineName should have length between 0 and " + ModelConstants.AIRLINE_NAME_MAX_LENGTH);
        }

        Airline airline  = new Airline(airlineName);

        airlineRepository.save(airline);
    }

    public Airline getAirportByName(String airportName){
        Optional<Airline> airline = airlineRepository.findByName(airportName);

        if(airline.isEmpty()){
            throw new ExpressionException("Arline was not found");
        }

        return airline.get();
    }
}
