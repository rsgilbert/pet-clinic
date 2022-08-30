package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.model.Specialty;
import net.passioncloud.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("map")
@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {

}
