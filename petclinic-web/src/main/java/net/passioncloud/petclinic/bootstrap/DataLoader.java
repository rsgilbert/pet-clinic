package net.passioncloud.petclinic.bootstrap;

import net.passioncloud.petclinic.model.Owner;
import net.passioncloud.petclinic.model.Vet;
import net.passioncloud.petclinic.services.OwnerService;
import net.passioncloud.petclinic.services.VetService;
import net.passioncloud.petclinic.services.map.OwnerServiceMap;
import net.passioncloud.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(){
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner0 = new Owner();
        owner0.setFirstName("John");
        owner0.setLastName("Peter");
        ownerService.save(owner0);
        Owner owner1 = new Owner();
        owner1.setFirstName("Marvin");
        owner1.setLastName("Omuzibu");
        ownerService.save(owner1);
        System.out.println("Loaded owners...");

        Vet vet0 = new Vet();
        vet0.setFirstName("Dr. Kisakye");
        vet0.setLastName("Margaret");
        vetService.save(vet0);
        Vet vet1 = new Vet();
        vet1.setFirstName("Dr. Nankya");
        vet1.setLastName("Patricia");
        vetService.save(vet1);
        System.out.println("Loaded vets...");


    }
}
