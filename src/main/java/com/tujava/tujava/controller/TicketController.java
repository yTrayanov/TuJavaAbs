package com.tujava.tujava.controller;

import com.tujava.tujava.dto.TicketCreateDto;
import com.tujava.tujava.models.Ticket;
import com.tujava.tujava.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;


    @PostMapping("/create")
    public ResponseEntity<Object> CreateTicket(@RequestBody TicketCreateDto ticketInfo){
        try{

            Ticket ticket = ticketService.CreateTicket(ticketInfo);

            return new ResponseEntity<>(ticket , HttpStatus.OK);

        } catch (ExpressionException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/{flightNumber}")
    public ResponseEntity<Object> GetFlightTickets(@PathVariable String flightNumber){

        try{
            List<Ticket> tickets = ticketService.GetFlightTickets(flightNumber);
            return new ResponseEntity<>(tickets ,HttpStatus.OK);
        } catch (ExpressionException e){
            return  new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
        }

    }
}
