package com.tujava.tujava.controller;

import com.tujava.tujava.dto.SectionDto;
import com.tujava.tujava.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/section")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @PostMapping("/create")
    public ResponseEntity<Void> CreateSection(@RequestBody SectionDto sectionInfo){
        try{
            sectionService.CreateSection(sectionInfo);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ExpressionException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
