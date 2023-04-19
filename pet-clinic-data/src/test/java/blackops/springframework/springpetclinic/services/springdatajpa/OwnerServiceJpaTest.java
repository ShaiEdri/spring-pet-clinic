package blackops.springframework.springpetclinic.services.springdatajpa;

import blackops.springframework.springpetclinic.model.Owner;
import blackops.springframework.springpetclinic.repositories.OwnerRepository;
import blackops.springframework.springpetclinic.repositories.PetRepository;
import blackops.springframework.springpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    OwnerRepository ownerRepository;
    @InjectMocks
    OwnerServiceJpa serviceJpa;
    Owner testingOwner;
    private final String LAST_NAME = "edri";
    private final Long ID = 1L;
    @BeforeEach
    void setUp() {
        testingOwner = Owner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(testingOwner);
        Owner owner = serviceJpa.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> testOwners = new HashSet<>();
        testOwners.add(Owner.builder().id(1L).build());
        testOwners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(testOwners);

        Set<Owner> owners = serviceJpa.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(testingOwner));
        Owner owner = serviceJpa.findById(ID);
        assertNotNull(owner);
    }
    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = serviceJpa.findById(ID);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(ID).build();
        when(ownerRepository.save(any())).thenReturn(testingOwner);
        Owner returnedOwner = serviceJpa.save(ownerToSave);
        assertNotNull(returnedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        serviceJpa.delete(testingOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        serviceJpa.deleteById(1L);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}