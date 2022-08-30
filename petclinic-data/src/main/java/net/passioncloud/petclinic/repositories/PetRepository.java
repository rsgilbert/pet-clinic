package net.passioncloud.petclinic.repositories;

import net.passioncloud.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
