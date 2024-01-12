package com.tujava.tujava.repositories;

import com.tujava.tujava.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport , Long> {
    Optional<Airport> findByName(String name);
}
