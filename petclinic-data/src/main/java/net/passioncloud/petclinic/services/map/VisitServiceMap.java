package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.model.Visit;
import net.passioncloud.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("map")
@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
}
