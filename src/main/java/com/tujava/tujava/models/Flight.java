package com.tujava.tujava.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Flight extends BaseModel {


    public Flight(){}

    public Flight(String flightNumber , Airline airline , Airport departureAirport , Airport arrivalAirport , Date departureDate , Date landingDate){
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.departureDate = departureDate;
        this.landingDate = landingDate;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    @Column(nullable = false, unique = true)
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "airlineId", nullable = false)
    private Airline airline;


    @Column(nullable = false)
    private Date departureDate;

    @Column(nullable = false)
    private Date landingDate;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private Airport arrivalAirport;


    @OneToMany(mappedBy = "flight", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Section> sections = new ArrayList<>();

    @OneToMany(mappedBy = "flight", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();

}
