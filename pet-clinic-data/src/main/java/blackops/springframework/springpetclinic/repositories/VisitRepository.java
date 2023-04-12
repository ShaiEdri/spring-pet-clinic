package blackops.springframework.springpetclinic.repositories;

import blackops.springframework.springpetclinic.model.PetType;
import blackops.springframework.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
