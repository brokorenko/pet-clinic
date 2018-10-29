package com.andy.petclinic.bootstrap;

import com.andy.petclinic.model.*;
import com.andy.petclinic.service.OwnerService;
import com.andy.petclinic.service.PetTypeService;
import com.andy.petclinic.service.SpecialtyService;
import com.andy.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType petType1 = new PetType();
        petType1.setName("dog");

        PetType dogType = petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType2.setName("Cat");

        PetType catType = petTypeService.save(petType2);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRediology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Mick");
        owner1.setLastName("Valen");
        owner1.setAddress("12233");
        owner1.setCity("Miami");
        owner1.setTelephone("1222333");

        Pet mickPet = new Pet();
        mickPet.setPetType(dogType);
        mickPet.setBirthDate(LocalDate.now());
        mickPet.setOwner(owner1);
        mickPet.setName("Rosco");

        owner1.getPetSet().add(mickPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Voven");
        owner2.setLastName("Kalip");
        owner2.setAddress("121");
        owner2.setCity("Miami");
        owner2.setTelephone("79899955");

        Pet vovenPet = new Pet();
        vovenPet.setPetType(catType);
        vovenPet.setBirthDate(LocalDate.now());
        vovenPet.setOwner(owner2);
        vovenPet.setName("Kot");

        owner2.getPetSet().add(vovenPet);

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Aka");
        vet1.getSpecialities().add(savedRediology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Kolla");
        vet2.setLastName("Erpia");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);
    }
}
