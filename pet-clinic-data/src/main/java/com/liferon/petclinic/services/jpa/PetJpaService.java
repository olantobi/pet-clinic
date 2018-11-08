package com.liferon.petclinic.services.jpa;

import com.liferon.petclinic.model.Pet;
import com.liferon.petclinic.repositories.PetRepository;
import com.liferon.petclinic.repositories.PetTypeRepository;
import com.liferon.petclinic.services.PetService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
@AllArgsConstructor
public class PetJpaService implements PetService {

    private PetRepository petRepository;
    private PetTypeRepository petTypeRepository;

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        if (object != null) {
            if (object.getPetType() != null && object.getPetType().getId() == null) {
                petTypeRepository.save(object.getPetType());
            }

            return petRepository.save(object);
        }

        return null;

    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);

        return pets;
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
