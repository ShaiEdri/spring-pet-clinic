package blackops.springframework.springpetclinic.services;

import blackops.springframework.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
