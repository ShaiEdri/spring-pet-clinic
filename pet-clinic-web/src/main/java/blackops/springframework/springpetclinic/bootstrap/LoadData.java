package blackops.springframework.springpetclinic.bootstrap;

import blackops.springframework.springpetclinic.model.*;
import blackops.springframework.springpetclinic.services.OwnerService;
import blackops.springframework.springpetclinic.services.PetTypeservice;
import blackops.springframework.springpetclinic.services.SpecialityService;
import blackops.springframework.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LoadData implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeservice petTypeservice;
    private final SpecialityService specialityService;

    public LoadData(OwnerService ownerService, VetService vetService, PetTypeservice petTypeservice, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeservice = petTypeservice;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int countPT = petTypeservice.findAll().size();
        if(countPT == 0){
            loadData();
        }

    }

    private void loadData() {
        PetType snake = new PetType();
        snake.setName("Snake");
        PetType savedSnakePtype = petTypeservice.save(snake);

        PetType bear = new PetType();
        snake.setName("bear");
        PetType savedBearPtype = petTypeservice.save(bear);

        Pet p1 = new Pet();
        p1.setPetType(snake);
        p1.setName("Shimi");
        p1.setBirthDate(LocalDate.now());

        Pet p2 = new Pet();
        p2.setPetType(bear);
        p2.setName("Yossi");
        p2.setBirthDate(LocalDate.now());

        // Specialities
        Speciality s1 = new Speciality();
        s1.setName("Surgery");
        specialityService.save(s1);

        Speciality s2 = new Speciality();
        s2.setName("Chiropract");
        specialityService.save(s2);

        Owner owner1 = new Owner();
        owner1.setFirstName("Avi");
        owner1.setLastName("Bitter");
        owner1.setAddress("ben gurion");
        owner1.setCity("Tel aviv");
        owner1.getPets().add(p1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Shoshi");
        owner2.setLastName("Bitter");
        owner2.setAddress("ben gurion");
        owner2.setCity("Tel aviv");
        owner2.getPets().add(p2);
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Yakov");
        vet1.setLastName("Edri");
        vet1.getSpecialities().add(s1);
        vetService.save(vet1);
        Vet vet2 = new Vet();
        vet2.setFirstName("Susan");
        vet2.setLastName("Edri");
        vet2.getSpecialities().add(s2);
        vetService.save(vet2);
        System.out.println("Loaded vets...");
    }
}
