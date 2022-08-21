package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.model.Owner;
import net.passioncloud.petclinic.model.Pet;


public class PetServiceMap extends AbstractMapService<Pet, Long> {
    @Override
    public Pet save(Pet pet) {
        Long id = pet.getId();
        if(id == null) {
            id = (long) this.map.size();
        }
        return this.save(id, pet);
    }
}
