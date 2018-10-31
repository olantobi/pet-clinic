package com.liferon.petclinic.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity<Type> implements Serializable {
    private Type id;
}
