package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.model.Owner;
import net.passioncloud.petclinic.model.Vet;
import net.passioncloud.petclinic.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Vet save(Vet vet) {
        Long id = vet.getId();
        if(id == null) {
            id = (long) this.map.size();
        }
        return this.save(id, vet);
    }
}
