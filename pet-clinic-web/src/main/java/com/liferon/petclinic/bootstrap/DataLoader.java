package com.liferon.petclinic.bootstrap;

import com.liferon.petclinic.model.*;
import com.liferon.petclinic.services.OwnerService;
import com.liferon.petclinic.services.PetTypeService;
import com.liferon.petclinic.services.SpecialtyService;
import com.liferon.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    @Override
    public void run(String... args) throws Exception {

        if (petTypeService.findAll().size() == 0)
            loadData();
    }

    private void loadData() {
        System.out.println("Loading pet types...");
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loading owners...");
        Owner owner1 = new Owner();
        owner1.setFirstName("Tobi");
        owner1.setLastName("Ola");
        owner1.setAddress("22, Osborne Foreshore Estate, Ikoyi");
        owner1.setCity("Lagos");
        owner1.setTelephone("08028183838");

        Pet tobisPet = new Pet();
        //tobisPet.setOwner(owner1);
        tobisPet.setPetType(savedDogPetType);
        tobisPet.setName("Lucky");
        tobisPet.setBirthDate(LocalDate.now().minusYears(5).minusMonths(6));
        owner1.getPets().add(tobisPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Adesare");
        owner2.setLastName("Adegbagi");
        owner2.setAddress("Quarry Road, Panseke");
        owner2.setCity("Abeokuta");
        owner2.setTelephone("08012358844");

        Pet adesPet = new Pet();
        //adesPet.setOwner(owner2);
        adesPet.setName("Kito");
        adesPet.setPetType(savedCatPetType);
        adesPet.setBirthDate(LocalDate.now().minusYears(2).minusMonths(7));
        owner2.getPets().add(adesPet);

        ownerService.save(owner2);
        System.out.println("Loading vets...");

        Specialty radiology = new Specialty();
        radiology.setName("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setName("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setName("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Stephen");
        vet1.setLastName("Oyedemi");
        vet1.getSpecialties().add(savedSurgery);
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Victor");
        vet2.setLastName("Jeko");
        vet2.getSpecialties().add(savedDentistry);

        vetService.save(vet2);
    }
}
