package com.tujava.tujava.models;

import com.tujava.tujava.utils.constants.ModelConstants;
import jakarta.persistence.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Airline extends BaseModel {

    public Airline(){}
    public Airline(String airlineName){
        this.name = airlineName;
    }
    @Column(nullable = false)
    @Size(min = 1, max = ModelConstants.AIRLINE_NAME_MAX_LENGTH)
    private String name;


    @OneToMany(mappedBy = "airline", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Flight> flights = new ArrayList<>();

    public String getName(){
        return this.name;
    }

}
