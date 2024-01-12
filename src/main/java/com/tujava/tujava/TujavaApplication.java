package com.tujava.tujava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.tujava.tujava.models")
public class TujavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TujavaApplication.class, args);
    }

}
