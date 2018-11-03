package com.liferon.petclinic.bootstrap;

import com.liferon.petclinic.model.Owner;
import com.liferon.petclinic.model.Vet;
import com.liferon.petclinic.services.OwnerService;
import com.liferon.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Tobi");
        owner1.setLastName("Ola");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bukola");
        owner2.setLastName("Oke");

        ownerService.save(owner2);
        System.out.println("Loading owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Stephen");
        vet1.setLastName("Oyedemi");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Victor");
        vet2.setLastName("Jeko");
        vetService.save(vet2);
    }
}
