package net.passioncloud.petclinic.services.jpa;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.passioncloud.petclinic.model.Specialty;
import net.passioncloud.petclinic.repositories.SpecialtyRepository;
import net.passioncloud.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@RequiredArgsConstructor
@Slf4j
@Profile({"default", "jpa"})
@Service
public class SpecialtyServiceJpa implements SpecialtyService {
    private final SpecialtyRepository specialtyRepository;


    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        specialtyRepository.delete(specialty);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
