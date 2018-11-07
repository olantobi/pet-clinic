package com.liferon.petclinic.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Visit extends BaseEntity<Integer> {

    private LocalDate date;
    private String description;
    private Pet pet;
}
