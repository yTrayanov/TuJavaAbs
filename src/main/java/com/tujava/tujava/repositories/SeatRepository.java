package com.tujava.tujava.repositories;

import com.tujava.tujava.models.Seat;
import com.tujava.tujava.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    Optional<List<Seat>> findSeatsBySection(Section section);
}
