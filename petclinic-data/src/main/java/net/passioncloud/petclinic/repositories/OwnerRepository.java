package net.passioncloud.petclinic.repositories;

import net.passioncloud.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
