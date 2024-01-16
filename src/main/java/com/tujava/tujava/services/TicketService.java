package com.tujava.tujava.services;

import com.tujava.tujava.dto.TicketCreateDto;
import com.tujava.tujava.models.Flight;
import com.tujava.tujava.models.Seat;
import com.tujava.tujava.models.Ticket;
import com.tujava.tujava.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private SeatService seatService;

    @Autowired
    FlightService flightService;


    public Ticket CreateTicket(TicketCreateDto ticketInfo){

            Flight flight = flightService.GetFlightByFlightNumber(ticketInfo.getFlightNumber());

            Seat seat = seatService.FindSeatById(ticketInfo.getSeatId());

            if(seat.isBooked()){
                throw new ExpressionException("Seat is already booked");
            }

            Ticket ticket = new Ticket(seat, flight,ticketInfo.getPassangerName());

            ticketRepository.save(ticket);

            seatService.BookSeat(seat);

            return ticket;
    }

    public List<Ticket> GetFlightTickets(String flightNumber){
        Flight flight = flightService.GetFlightByFlightNumber(flightNumber);

        Optional<List<Ticket>> tickets = ticketRepository.findAllByFlight(flight);

        if(tickets.isEmpty()){
            throw  new ExpressionException("Flight have no tickets");
        }

        return  tickets.get();
    }
}
