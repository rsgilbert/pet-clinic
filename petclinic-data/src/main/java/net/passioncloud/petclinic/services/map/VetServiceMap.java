package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.model.Owner;
import net.passioncloud.petclinic.model.Vet;

public class VetServiceMap extends AbstractMapService<Vet, Long> {
    @Override
    public Vet save(Vet vet) {
        Long id = vet.getId();
        if(id == null) {
            id = (long) this.map.size();
        }
        return this.save(id, vet);
    }
}
