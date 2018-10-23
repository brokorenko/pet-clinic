package com.andy.petclinic.service;

import com.andy.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet Vet);

    Set<Vet> findAll();
}
