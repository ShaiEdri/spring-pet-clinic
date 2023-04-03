package blackops.springframework.springpetclinic.bootstrap;

import blackops.springframework.springpetclinic.model.Owner;
import blackops.springframework.springpetclinic.model.Vet;
import blackops.springframework.springpetclinic.services.OwnerService;
import blackops.springframework.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
  private final OwnerService ownerService;
  private final VetService vetService;

  public DataLoader(OwnerService ownerService, VetService vetService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
  }

  @Override
  public void run(String... args) throws Exception {
    Owner owner1 = new Owner();
    owner1.setId(1L);
    owner1.setFirstName("Avi");
    owner1.setLastName("Bitter");
    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setId(2L);
    owner2.setFirstName("Shoshi");
    owner2.setLastName("Bitter");
    ownerService.save(owner2);

    Vet vet1 = new Vet();
    vet1.setId(1L);
    vet1.setFirstName("Yakov");
    vet1.setLastName("Edri");
    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setId(2L);
    vet2.setFirstName("Susan");
    vet2.setLastName("Edri");
    vetService.save(vet2);

    System.out.println("Loaded vets...");
  }
}
