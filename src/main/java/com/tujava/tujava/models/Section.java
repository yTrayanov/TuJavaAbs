package com.tujava.tujava.models;

import com.tujava.tujava.utils.constants.ModelConstants;
import jakarta.persistence.*;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section extends BaseModel{


    public Section(){}

    public Section(int rows , int columns, SeatClass seatClass, Flight flight){
        this.rows = rows;
        this.columns = columns;
        this.seatClass = seatClass;
        this.flight = flight;
        this.availableSeatsCount = rows * columns;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Column
    private int availableSeatsCount;

    @Column(nullable = false)
    @Size(min = ModelConstants.SECTION_MIN_ROWS , max = ModelConstants.SECTION_MAX_ROWS)
    private int rows;

    @Column(nullable = false)
    @Size(min = ModelConstants.SECTION_MIN_COLUMNS , max = ModelConstants.SECTION_MAX_COLUMNS)
    private int columns;

    @Column
    public SeatClass seatClass;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Seat> seats = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;
}
