package blackops.springframework.springpetclinic.bootstrap;

import blackops.springframework.springpetclinic.model.Owner;
import blackops.springframework.springpetclinic.model.PetType;
import blackops.springframework.springpetclinic.model.Vet;
import blackops.springframework.springpetclinic.services.OwnerService;
import blackops.springframework.springpetclinic.services.PetTypeservice;
import blackops.springframework.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadData implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeservice petTypeservice;

    public LoadData(OwnerService ownerService, VetService vetService, PetTypeservice petTypeservice) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeservice = petTypeservice;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType snake = new PetType();
        snake.setName("Snake");
        PetType savedSnakePtype = petTypeservice.save(snake);

        PetType bear = new PetType();
        snake.setName("bear");
        PetType savedBearPtype = petTypeservice.save(bear);

        Owner owner1 = new Owner();
        owner1.setFirstName("Avi");
        owner1.setLastName("Bitter");
        owner1.setAddress("ben gurion");
        owner1.setCity("Tel aviv");
        ownerService.save(owner1);
        Owner owner2 = new Owner();
        owner2.setFirstName("Shoshi");
        owner2.setLastName("Bitter");
        owner2.setAddress("ben gurion");
        owner2.setCity("Tel aviv");
        ownerService.save(owner2);
        Vet vet1 = new Vet();
        vet1.setFirstName("Yakov");
        vet1.setLastName("Edri");
        vetService.save(vet1);
        Vet vet2 = new Vet();
        vet2.setFirstName("Susan");
        vet2.setLastName("Edri");
        vetService.save(vet2);
        System.out.println("Loaded vets...");

    }
}
