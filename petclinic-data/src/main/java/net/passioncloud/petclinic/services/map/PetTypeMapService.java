package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.model.PetType;
import net.passioncloud.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("map")
@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
