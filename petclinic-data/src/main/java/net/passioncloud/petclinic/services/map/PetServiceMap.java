package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.model.Owner;
import net.passioncloud.petclinic.model.Pet;
import net.passioncloud.petclinic.services.PetService;


public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Pet save(Pet pet) {
        Long id = pet.getId();
        if(id == null) {
            id = (long) this.map.size();
        }
        return this.save(id, pet);
    }
}
