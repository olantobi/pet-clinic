package com.liferon.petclinic.services.jpa;

import com.liferon.petclinic.model.Owner;
import com.liferon.petclinic.repositories.OwnerRepository;
import com.liferon.petclinic.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService {

    private OwnerRepository ownerRepository;
    private PetJpaService petJpaService;

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> petJpaService.save(pet));
            } else {
                throw new RuntimeException("Pets is required");
            }

            return ownerRepository.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);

        return owners;
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
