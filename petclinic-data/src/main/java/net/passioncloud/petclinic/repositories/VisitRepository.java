package net.passioncloud.petclinic.repositories;

import net.passioncloud.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
