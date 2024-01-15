package com.tujava.tujava.models;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Flight extends BaseModel {


    public Flight(){}

    public Flight(String flightNumber , Airline airline , Airport departureAirport , Airport arrivalAirport , LocalDate departureDate , LocalDate landingDate){
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.departureDate = departureDate;
        this.landingDate = landingDate;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airline getAirline() {
        return airline;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalDate getLandingDate() {
        return landingDate;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setLandingDate(LocalDate landingDate) {
        this.landingDate = landingDate;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Column(nullable = false, unique = true)
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "airlineId", nullable = false)
    private Airline airline;



    @Column(nullable = false)
    private LocalDate departureDate;

    @Column(nullable = false)
    private LocalDate landingDate;

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
