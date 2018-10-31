package com.liferon.petclinic.services;

import com.liferon.petclinic.model.Owner;

public interface OwnerService extends GenericService<Owner> {

    Owner findByLastName(String lastName);
}
