package com.tujava.tujava.repositories;

import com.tujava.tujava.models.Flight;
import com.tujava.tujava.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<List<Ticket>> findAllByFlight(Flight flight);
}
