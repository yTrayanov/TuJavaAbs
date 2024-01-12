package com.tujava.tujava.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
}
