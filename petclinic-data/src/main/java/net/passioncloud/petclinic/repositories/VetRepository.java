package net.passioncloud.petclinic.repositories;

import net.passioncloud.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
