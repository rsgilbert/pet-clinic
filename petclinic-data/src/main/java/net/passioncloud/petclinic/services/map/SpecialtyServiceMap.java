package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.model.Specialty;
import net.passioncloud.petclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {

}
