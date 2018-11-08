package com.liferon.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "visits")
@EqualsAndHashCode(exclude = {"pet"})
public class Visit extends BaseEntity<Integer> {

    private LocalDate date;
    private String description;

    @ManyToOne
    private Pet pet;
}
