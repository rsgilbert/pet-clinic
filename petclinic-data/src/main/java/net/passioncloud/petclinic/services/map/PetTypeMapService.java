package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.model.PetType;
import net.passioncloud.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}