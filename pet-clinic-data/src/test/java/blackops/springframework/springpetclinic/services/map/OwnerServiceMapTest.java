package blackops.springframework.springpetclinic.services.map;

import blackops.springframework.springpetclinic.model.Owner;
import blackops.springframework.springpetclinic.services.PetService;
import blackops.springframework.springpetclinic.services.springdatajpa.OwnerServiceJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {OwnerServiceMap.class, PetTypeMapService.class, PetServiceMap.class})
class OwnerServiceMapTest {
    OwnerServiceMap ownerServiceMap;
    final Long id = 1L;
    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().lastName("edri").id(id).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(id);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(id));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void save() {
        Owner owner = ownerServiceMap.save(Owner.builder().build());
        assertEquals(2L, owner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(id);
        assertEquals(owner.getId(), id);
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName("edri");
        assertNotNull(owner);
        assertEquals(id, owner.getId());
    }
}