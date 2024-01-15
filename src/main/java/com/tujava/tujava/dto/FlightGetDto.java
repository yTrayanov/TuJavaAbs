package com.tujava.tujava.dto;

import com.tujava.tujava.models.Flight;
import com.tujava.tujava.models.Seat;
import com.tujava.tujava.models.SeatClass;
import com.tujava.tujava.models.Section;

import java.util.List;
import java.util.Map;

public class FlightGetDto {

    private Flight flight;
    List<Section> sections;

    Map<SeatClass , List<Seat>> seats;

    public Map<SeatClass , List<Seat>> getSeats() {
        return seats;
    }

    public void setSeats(Map<SeatClass , List<Seat>> seats) {
        this.seats = seats;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
