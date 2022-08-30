package net.passioncloud.petclinic.repositories;

import net.passioncloud.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
