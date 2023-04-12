package blackops.springframework.springpetclinic.repositories;

import blackops.springframework.springpetclinic.model.PetType;
import blackops.springframework.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
