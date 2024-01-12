package com.tujava.tujava.controller;

import com.tujava.tujava.models.Airport;
import com.tujava.tujava.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @PostMapping("/create/{name}")
    public ResponseEntity<Void> createAirport(@PathVariable String name){

        airportService.CreateAirport(name);

        return new  ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{name}")
    public ResponseEntity<Airport> GetAirport(@PathVariable String name){
        Airport airport = airportService.getAirportByName(name);

        return new ResponseEntity<>(airport, HttpStatus.OK);
    }
}
