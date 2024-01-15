package com.tujava.tujava.controller;

import com.tujava.tujava.dto.AirportAirlineDto;
import com.tujava.tujava.services.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @PostMapping("/create/")
    public ResponseEntity<String> createAirport(@RequestBody AirportAirlineDto model){

        try{
            airlineService.CreateAirline(model.getName());

            return new  ResponseEntity<>("Airline created",HttpStatus.OK);
        } catch (ExpressionException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
