package blackops.springframework.springpetclinic.services;

import blackops.springframework.springpetclinic.model.Owner;
import blackops.springframework.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
