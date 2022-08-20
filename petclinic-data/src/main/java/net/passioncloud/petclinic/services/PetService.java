package net.passioncloud.petclinic.services;

import net.passioncloud.petclinic.model.Owner;
import net.passioncloud.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
