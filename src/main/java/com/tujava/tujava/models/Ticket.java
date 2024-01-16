package com.tujava.tujava.models;

import jakarta.persistence.*;

@Entity
public class Ticket extends BaseModel {


    public Ticket(){}

    public Ticket(Seat seat , Flight flight,String passangerName){
        this.seat = seat;
        this.passengerName = passangerName;
        this.flight = flight;
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "seat_id", unique = true, nullable = false)
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="flight_id")
    private Flight flight;


    @Column
    private String passengerName;

    public Seat getSeat() {
        return seat;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getPassengerName() {
        return passengerName;
    }
}
