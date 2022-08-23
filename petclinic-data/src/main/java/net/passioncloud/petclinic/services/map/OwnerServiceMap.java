package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.model.Owner;
import net.passioncloud.petclinic.services.OwnerService;

import java.util.Map;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner save(Owner owner) {
        Long id = owner.getId();
        if(id == null) {
            id = (long) this.map.size();
        }
        return this.save(id, owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        for(Map.Entry<Long,Owner> entry: this.map.entrySet()) {
            if(entry.getValue().getLastName().equals(lastName)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
