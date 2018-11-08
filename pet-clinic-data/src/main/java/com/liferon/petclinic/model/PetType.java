package com.liferon.petclinic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "types")
public class PetType extends NamedEntity<Long> {

}
