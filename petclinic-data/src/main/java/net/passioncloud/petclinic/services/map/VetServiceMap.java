package net.passioncloud.petclinic.services.map;


import org.springframework.stereotype.Service;

import net.passioncloud.petclinic.model.Vet;
import net.passioncloud.petclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Vet save(Vet vet) {
        Long id = vet.getId();
        if(id == null) {
            id = (long) this.map.size();
        }
        vet.setId(id);
        return this.save(id, vet);
    }
}
