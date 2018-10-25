package com.andy.petclinic.service.map;

import com.andy.petclinic.model.Vet;
import com.andy.petclinic.service.CrudService;
import com.andy.petclinic.service.VetService;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
