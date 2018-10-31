package com.liferon.petclinic.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Pet extends NamedEntity<Long> {

    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

}
