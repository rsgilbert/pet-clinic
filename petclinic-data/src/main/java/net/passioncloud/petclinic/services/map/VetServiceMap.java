package net.passioncloud.petclinic.services.map;


import org.springframework.stereotype.Service;

import net.passioncloud.petclinic.model.Vet;
import net.passioncloud.petclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

}
