package com.tujava.tujava.controller;

import com.tujava.tujava.services.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @PostMapping("/create/{name}")
    public ResponseEntity<Void> createAirport(@PathVariable String name){

        airlineService.CreateAirline(name);

        return new  ResponseEntity<>(HttpStatus.OK);
    }
}
