package com.andy.petclinic.bootstrap;

import com.andy.petclinic.model.Owner;
import com.andy.petclinic.model.PetType;
import com.andy.petclinic.model.Vet;
import com.andy.petclinic.service.OwnerService;
import com.andy.petclinic.service.PetTypeService;
import com.andy.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Mick");
        owner1.setLastName("Valen");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Voven");
        owner2.setLastName("Kalip");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Aka");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Kolla");
        vet2.setLastName("Erpia");

        vetService.save(vet2);

        PetType petType1 = new PetType();
        petType1.setName("Gog");

        petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType2.setName("Cat");

        petTypeService.save(petType2);
    }
}
