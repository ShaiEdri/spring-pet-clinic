package blackops.springframework.springpetclinic.repositories;

import blackops.springframework.springpetclinic.model.Pet;
import blackops.springframework.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
