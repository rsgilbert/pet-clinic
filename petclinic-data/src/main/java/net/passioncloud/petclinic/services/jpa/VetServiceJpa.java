package net.passioncloud.petclinic.services.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.passioncloud.petclinic.model.Vet;
import net.passioncloud.petclinic.repositories.VetRepository;
import net.passioncloud.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@RequiredArgsConstructor
@Slf4j
@Profile({"default", "jpa"})
@Service
public class VetServiceJpa implements VetService {
    private final VetRepository vetRepository;

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        for (Vet v : vets) {
            System.out.println(v);
        }
        ;
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
