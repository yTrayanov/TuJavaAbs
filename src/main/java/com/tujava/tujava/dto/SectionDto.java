package com.tujava.tujava.dto;

import com.tujava.tujava.models.SeatClass;
import com.tujava.tujava.utils.constants.ModelConstants;
import jakarta.persistence.Column;

import javax.validation.constraints.Size;

public class SectionDto {


    public String getFlightNumber() {
        return flightNumber;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }


    private String flightNumber;

    private int rows;

    private int columns;

    private SeatClass seatClass;
}
