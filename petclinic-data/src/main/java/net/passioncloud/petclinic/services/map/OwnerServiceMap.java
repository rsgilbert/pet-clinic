package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.model.Owner;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> {
    @Override
    public Owner save(Owner owner) {
        Long id = owner.getId();
        if(id == null) {
            id = (long) this.map.size();
        }
        return this.save(id, owner);
    }
}
