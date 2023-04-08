package blackops.springframework.springpetclinic.services.map;

import blackops.springframework.springpetclinic.model.Pet;
import blackops.springframework.springpetclinic.model.PetType;
import blackops.springframework.springpetclinic.services.PetService;
import blackops.springframework.springpetclinic.services.PetTypeservice;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeservice {
    @Override
    public Set<PetType> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(PetType object) {

    }

    @Override
    public PetType save(PetType object) {
        return null;
    }

    @Override
    public PetType findById(Long id) {
        return null;
    }
}
