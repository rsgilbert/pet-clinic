package net.passioncloud.petclinic.services.jpa;

import lombok.RequiredArgsConstructor;
import net.passioncloud.petclinic.model.Owner;
import net.passioncloud.petclinic.repositories.OwnerRepository;
import net.passioncloud.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@RequiredArgsConstructor
@Profile({"default", "jpa"})
@Service
public class OwnerServiceJpa implements OwnerService {
    private final OwnerRepository ownerRepository;

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
