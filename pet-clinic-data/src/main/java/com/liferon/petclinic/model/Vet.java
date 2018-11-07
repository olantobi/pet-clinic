package com.liferon.petclinic.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Vet extends Person {

    Set<Specialty> specialties = new HashSet<>();
}
