package com.tujava.tujava.services;

import com.tujava.tujava.dto.SectionDto;
import com.tujava.tujava.models.Flight;
import com.tujava.tujava.models.Seat;
import com.tujava.tujava.models.Section;
import com.tujava.tujava.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private FlightService flightService;

    public void CreateSection(SectionDto sectionInfo){
        Flight flight = flightService.GetFlightByFlightNumber(sectionInfo.getFlightNumber());

        Section section = new Section(sectionInfo.getRows(), sectionInfo.getColumns(),sectionInfo.getSeatClass() ,flight);

        List<Seat> seats = new ArrayList<>();

        for(int row=0; row < sectionInfo.getRows(); row++){
            for(int col=0; col < sectionInfo.getColumns(); col++){
                Seat seat = new Seat(row, col,section);

                seats.add(seat);
            }
        }


        section.setSeats(seats);

        sectionRepository.save(section);
    }

    public List<Section> FindSectionsByFlight(Flight flight){
        Optional<List<Section>> sections = sectionRepository.findSectionsByFlight(flight);

        if(sections.isEmpty()){
            throw new ExpressionException("Sections not found");
        }

        return  sections.get();
    }

}
