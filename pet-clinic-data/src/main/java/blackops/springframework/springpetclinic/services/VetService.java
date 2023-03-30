package blackops.springframework.springpetclinic.services;

import blackops.springframework.springpetclinic.model.Owner;
import blackops.springframework.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
