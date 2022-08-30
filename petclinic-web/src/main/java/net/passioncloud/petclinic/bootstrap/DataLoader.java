package net.passioncloud.petclinic.bootstrap;

import net.passioncloud.petclinic.model.*;
import net.passioncloud.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        dog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        cat = petTypeService.save(cat);

        PetType pig = new PetType();
        pig.setName("Pig");
        pig = petTypeService.save(pig);

        PetType donkey = new PetType();
        donkey.setName("Donkey");
        donkey = petTypeService.save(donkey);


        Owner owner0 = new Owner();
        owner0.setFirstName("John");
        owner0.setLastName("Peter");
        owner0.setAddress("Kuleekana road");
        owner0.setCity("Kampala");
        owner0.setTelephone("0233");
        owner0 = ownerService.save(owner0);

        Pet police = new Pet();
        police.setPetType(dog);
        police.setOwner(owner0);
        police.setBirthDay(LocalDate.now());
        police.setName("Police");
        police = petService.save(police);
        owner0.getPets().add(police);
        ownerService.save(owner0);

        Owner owner1 = new Owner();
        owner1.setFirstName("Marvin");
        owner1.setLastName("Omuzibu");
        owner1.setAddress("Kyebando");
        owner1.setCity("Kampala");
        owner1.setTelephone("543");
        owner1 = ownerService.save(owner1);
        Pet cat1 = new Pet();
        cat1.setBirthDay(LocalDate.now());
        cat1.setName("Omuzimbi cat 1");
        cat1.setOwner(owner1);
        cat1.setPetType(cat);
        cat1 = petService.save(cat1);
        owner1.getPets().add(cat1);

        Pet donkey1 = new Pet();
        donkey1.setBirthDay(LocalDate.now());
        donkey1.setName("Omuzimbi donkey 1");
        donkey1.setOwner(owner1);
        donkey1.setPetType(donkey);
        donkey1 = petService.save(donkey1);
        owner1.getPets().add(donkey1);
        ownerService.save(owner1);
        System.out.println("Loaded owners...");

        Vet vet0 = new Vet();
        vet0.setFirstName("Dr. Kisakye");
        vet0.setLastName("Margaret");

        Specialty surgery = new Specialty("Surgery");
        surgery = specialtyService.save(surgery);

        Specialty radiology = new Specialty("Radiology");
        radiology = specialtyService.save(radiology);
        vet0.getSpecialties().add(surgery);
        vet0.getSpecialties().add(radiology);
        vetService.save(vet0);


        Vet vet1 = new Vet();
        vet1.setFirstName("Dr. Nankya");
        vet1.setLastName("Patricia");
        Specialty dentistry = new Specialty("Dentistry");
        dentistry = specialtyService.save(dentistry);
        vet1.getSpecialties().add(dentistry);
        vetService.save(vet1);
        System.out.println("Loaded vets...");

        // add visit
        Visit donkeyVisit = new Visit();
        donkeyVisit.setDate(LocalDate.now());
        donkeyVisit.setDescription("Test donkey visit 1");
        donkeyVisit.setPet(donkey1);
        donkeyVisit = visitService.save(donkeyVisit);

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Test cat visit 1");
        catVisit.setPet(cat1);
        catVisit = visitService.save(catVisit);
    }
}
