package com.liferon.petclinic.model;

import lombok.Data;

@Data
public class Person extends BaseEntity<Long> {
    private String firstName;
    private String lastName;

}
