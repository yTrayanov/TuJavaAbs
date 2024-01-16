package com.tujava.tujava.services;

import com.tujava.tujava.models.Seat;
import com.tujava.tujava.models.Section;
import com.tujava.tujava.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;
    public List<Seat> GetSeatsBySection(Section section){
        Optional<List<Seat>> seats = seatRepository.findSeatsBySection(section);

        if(seats.isEmpty()){
            throw  new ExpressionException("Seats not found");
        }

        return seats.get();
    }

    public Seat FindSeatById(Long id){
        Optional<Seat> seat = seatRepository.findById(id);

        if(seat.isEmpty()){
            throw new ExpressionException("Seat not found");
        }

        return seat.get();
    }

    public Seat BookSeat(Seat seat){
        seat.setBooked(true);

        seatRepository.save(seat);

        return seat;
    }
}
