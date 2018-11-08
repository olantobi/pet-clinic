package com.liferon.petclinic.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class NamedEntity<Type> extends BaseEntity<Type> {
    private String name;
}
