package com.tujava.tujava.controller;

import com.tujava.tujava.dto.FlightCreateUpdateDto;
import com.tujava.tujava.dto.FlightGetDto;
import com.tujava.tujava.models.Flight;
import com.tujava.tujava.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;


    @GetMapping("/{flightNumber}")
    public ResponseEntity<Object> GetFlight(@PathVariable String flightNumber){
        try{
            FlightGetDto flight = flightService.GetFlight((flightNumber));
            return new ResponseEntity<>(flight , HttpStatus.OK);
        } catch (ExpressionException e){
            return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create/")
    public ResponseEntity<String> CreateFlight(@RequestBody FlightCreateUpdateDto flightInfo){

        try{
            flightService.CreateFlight(flightInfo);

            return new ResponseEntity<>("Flight created" , HttpStatus.OK);
        } catch (ExpressionException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/delete/{flightNumber}")
    public ResponseEntity<String> DeleteFlight(@PathVariable String flightNumber){

        try{
            flightService.DeleteFlight(flightNumber);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ExpressionException e){
            return  new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/update-flight")
    public ResponseEntity<Object> UpdateFlight(@RequestBody FlightCreateUpdateDto flightInfo){

        try{
            Flight updatedFlight = flightService.UpdateFlight(flightInfo);
            return new ResponseEntity<>(updatedFlight , HttpStatus.OK);
        } catch (ExpressionException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
