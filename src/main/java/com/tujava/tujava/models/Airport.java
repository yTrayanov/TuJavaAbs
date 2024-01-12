package com.tujava.tujava.models;

import com.tujava.tujava.utils.constants.ModelConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Airport extends BaseModel {

    public Airport(){}

    public Airport(String airportName){
        this.name = airportName;
    }

    public String getName(){
        return this.name;
    }

    @Column(nullable = false , unique = true)
    @Size(min = ModelConstants.AIRPORT_NAME_LENGTH, max = ModelConstants.AIRPORT_NAME_LENGTH)
    @Pattern(message = "Invalid airport name", regexp = "^[A-Z]+$")
    private String name;

    @OneToMany(mappedBy = "departureAirport")
    private List<Flight> departingFlights = new ArrayList<>();

    @OneToMany(mappedBy = "arrivalAirport")
    private List<Flight> incomingFlights = new ArrayList<>();
}
