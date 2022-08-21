package net.passioncloud.petclinic.services;

import net.passioncloud.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
