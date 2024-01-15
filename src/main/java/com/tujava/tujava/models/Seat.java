package com.tujava.tujava.models;

import jakarta.persistence.*;

import javax.validation.constraints.Max;

@Entity
public class Seat extends BaseModel {


    public Seat(){}

    public Seat(int row, int col, Section section){
        this.row = row;
        this.col = col;
        this.section = section;
        this.isBooked = false;
    }

    @Column(nullable = false)
    private int row;

    @Column(nullable = false)
    private int col;

    @Column
    private boolean isBooked;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @Column
    private String passangerName;

    @OneToOne(mappedBy = "seat")
    private Ticket ticket;

    public String getSeatNumber(){
        return this.row + 1 + "" + (char)(this.col + 'A');
    }

    public boolean isBooked() {
        return isBooked;
    }
}
