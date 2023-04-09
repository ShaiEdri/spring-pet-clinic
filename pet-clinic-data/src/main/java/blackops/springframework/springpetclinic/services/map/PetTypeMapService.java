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
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
