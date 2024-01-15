package com.tujava.tujava.repositories;

import com.tujava.tujava.models.Flight;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findByFlightNumber(String flightNumber);
    void deleteByFlightNumber(String flightNumber);
}