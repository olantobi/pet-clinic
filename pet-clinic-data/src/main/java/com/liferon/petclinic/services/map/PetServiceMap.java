package com.liferon.petclinic.services.map;

import com.liferon.petclinic.model.Pet;
import com.liferon.petclinic.services.PetService;
import com.liferon.petclinic.services.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
@RequiredArgsConstructor
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    private final PetTypeService petTypeService;

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        if (object != null) {
            if (object.getPetType() != null && object.getPetType().getId() == null) {
                petTypeService.save(object.getPetType());
            }
            return super.save(object);
        }

        return null;
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
