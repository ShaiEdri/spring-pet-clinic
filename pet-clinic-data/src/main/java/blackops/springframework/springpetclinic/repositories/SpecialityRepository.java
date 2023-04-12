package blackops.springframework.springpetclinic.repositories;

import blackops.springframework.springpetclinic.model.PetType;
import blackops.springframework.springpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
