package com.andy.petclinic.service.map;

import com.andy.petclinic.model.Owner;
import com.andy.petclinic.model.Pet;
import com.andy.petclinic.service.OwnerService;
import com.andy.petclinic.service.PetService;
import com.andy.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPetSet() != null) {
                object.getPetSet().forEach(pet ->
                {
                    if (pet.getPetType() != null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    } else
                        throw new RuntimeException("Pet Type required");

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(object);

        } else {
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
