package com.tujava.tujava.controller;

import com.tujava.tujava.dto.AirportAirlineDto;
import com.tujava.tujava.models.Airport;
import com.tujava.tujava.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @PostMapping("/create/")
    public ResponseEntity<String> createAirport(@RequestBody AirportAirlineDto model){

        try{
            airportService.CreateAirport(model.getName());

            return new  ResponseEntity<>("Airport created",HttpStatus.OK);

        } catch (ExpressionException e){
            return new  ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{name}")
    public ResponseEntity<Object> GetAirport(@PathVariable String name){
        try{
            Airport airport = airportService.getAirportByName(name);

            return new ResponseEntity<>(airport, HttpStatus.OK);
        } catch (ExpressionException e){
            return new  ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
