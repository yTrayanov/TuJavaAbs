package com.tujava.tujava.models;

import jakarta.persistence.*;

@Entity
public class Ticket extends BaseModel {


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "seat_id", unique = true, nullable = false)
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="flight_id", nullable = false)
    private Flight flight;


    @Column
    private String passengerName;
}
