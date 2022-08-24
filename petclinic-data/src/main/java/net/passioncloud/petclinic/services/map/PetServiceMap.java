package net.passioncloud.petclinic.services.map;

import org.springframework.stereotype.Service;

import net.passioncloud.petclinic.model.Pet;
import net.passioncloud.petclinic.services.PetService;


@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

}
