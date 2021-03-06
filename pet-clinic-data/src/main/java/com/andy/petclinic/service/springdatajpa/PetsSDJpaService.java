package com.andy.petclinic.service.springdatajpa;

import com.andy.petclinic.model.Pet;
import com.andy.petclinic.repository.PetRepository;
import com.andy.petclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetsSDJpaService implements PetService {

    private final PetRepository petRepository;

    public PetsSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {

        Set<Pet> pets = new HashSet<>();

        petRepository.findAll().forEach(pets::add);

        return pets;
    }

    @Override
    public Pet findById(Long id) {

        Optional<Pet> pet = petRepository.findById(id);

        return pet.orElse(null);

    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
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
