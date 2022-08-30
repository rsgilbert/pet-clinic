package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.model.Owner;
import net.passioncloud.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Map;

@Profile("map")
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

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
