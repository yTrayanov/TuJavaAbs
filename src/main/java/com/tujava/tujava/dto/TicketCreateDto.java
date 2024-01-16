package com.tujava.tujava.dto;

public class TicketCreateDto {
    private Long seatId;

    private String passangerName;

    private String flightNumber;

    public String getFlightNumber() {
        return flightNumber;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public String getPassangerName() {
        return passangerName;
    }
}
