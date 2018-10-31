package com.liferon.petclinic.services;

import java.util.Set;

public interface CrudService<Type, ID> {

    Type findById(ID id);

    Type save(Type object);

    Set<Type> findAll();

    void delete(Type object);

    void deleteById(ID id);
}
