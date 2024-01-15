package com.tujava.tujava.repositories;

import com.tujava.tujava.models.Flight;
import com.tujava.tujava.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SectionRepository extends JpaRepository<Section, Long> {
    Optional<List<Section>> findSectionsByFlight(Flight flight);
}
