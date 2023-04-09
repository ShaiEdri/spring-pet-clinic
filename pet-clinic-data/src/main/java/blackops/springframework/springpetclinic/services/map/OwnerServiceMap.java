package blackops.springframework.springpetclinic.services.map;

import blackops.springframework.springpetclinic.model.Owner;
import blackops.springframework.springpetclinic.model.Pet;
import blackops.springframework.springpetclinic.services.OwnerService;
import blackops.springframework.springpetclinic.services.PetService;
import blackops.springframework.springpetclinic.services.PetTypeservice;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeservice petTypeservice;
    private final PetService petService;

    public OwnerServiceMap(PetTypeservice petTypeservice, PetService petService) {
        this.petTypeservice = petTypeservice;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet->{
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeservice.save(pet.getPetType()));
                        }
                    }else {
                        throw new RuntimeException("Required pet type");
                    }
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }

    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
