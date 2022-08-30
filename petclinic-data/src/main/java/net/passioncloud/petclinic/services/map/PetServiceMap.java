package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.model.Pet;
import net.passioncloud.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Profile("map")
@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

}
