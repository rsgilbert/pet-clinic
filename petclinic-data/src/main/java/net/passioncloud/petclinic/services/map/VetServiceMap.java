package net.passioncloud.petclinic.services.map;


import net.passioncloud.petclinic.model.Vet;
import net.passioncloud.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("map")
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

}
