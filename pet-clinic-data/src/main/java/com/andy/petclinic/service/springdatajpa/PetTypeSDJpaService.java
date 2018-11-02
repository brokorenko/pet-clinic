package com.andy.petclinic.service.springdatajpa;

import com.andy.petclinic.model.PetType;
import com.andy.petclinic.repository.PetTypeRepository;
import com.andy.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {

        Set<PetType> petTypes = new HashSet<>();

        petTypeRepository.findAll().forEach(petTypes::add);

        return petTypes;
    }

    @Override
    public PetType findById(Long id) {

        Optional<PetType> petType = petTypeRepository.findById(id);

        return petType.orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {

        petTypeRepository.delete(object);

    }

    @Override
    public void deleteById(Long id) {

        petTypeRepository.deleteById(id);

    }
}
