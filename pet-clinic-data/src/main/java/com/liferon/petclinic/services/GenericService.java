package com.liferon.petclinic.services;

import java.util.Set;

public interface GenericService<Type> {

    Type findById(Long id);

    Type save(Type owner);

    Set<Type> findAll();
}
