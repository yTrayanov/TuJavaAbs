package com.tujava.tujava.controller;

import com.tujava.tujava.dto.FlightCreateDto;
import com.tujava.tujava.models.Flight;
import com.tujava.tujava.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/create")
    public ResponseEntity<Void> CreateFlight(@RequestBody FlightCreateDto flightInfo){

        flightService.CreateFlight(flightInfo);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> DeleteFlight(@RequestBody String flightNumber){

        flightService.DeleteFlight(flightNumber);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Flight> UpdateFlight(@RequestBody FlightCreateDto flightInfo){


        return new ResponseEntity<>(new Flight() , HttpStatus.OK);
    }
}
