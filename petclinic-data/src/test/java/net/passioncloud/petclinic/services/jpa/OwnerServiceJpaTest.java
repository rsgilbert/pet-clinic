package net.passioncloud.petclinic.services.jpa;

import net.passioncloud.petclinic.model.Owner;
import net.passioncloud.petclinic.repositories.OwnerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

/**
 * Test OwnerServiceJpa
 * We test the interactions of the service with the repository.
 * We don't test the repository since that is an extension of Spring's CrudRepository interface
 * We want to avoid testing framework code
 */
@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerServiceJpa ownerServiceJpa;

    Owner testOwner1 = Owner.builder().city("Gulu").build();
    Owner testOwner2 = Owner.builder().city("Kabale").build();
    List<Owner> owners = List.of(new Owner[]{testOwner1, testOwner2});

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        Mockito.when(ownerRepository.findAll()).thenReturn(owners);
        Assertions.assertThat(ownerServiceJpa.findAll()).hasSize(owners.size());
    }

    @Test
    void findById() {
        Mockito.when(ownerRepository.findById(Mockito.any())).thenReturn(Optional.of(testOwner2));
        Assertions.assertThat(ownerServiceJpa.findById(5L)).isEqualTo(testOwner2);
    }

    @Test
    void save() {
        Mockito.when(ownerRepository.save(Mockito.any())).thenReturn(testOwner1);
        Assertions.assertThat(ownerServiceJpa.save(testOwner1)).isEqualTo(testOwner1);
    }

    @Test
    void delete() {
        ownerServiceJpa.delete(testOwner1);
        Mockito.verify(ownerRepository).delete(testOwner1);
    }

    @Test
    void deleteById() {
        ownerServiceJpa.deleteById(3L);
        Mockito.verify(ownerRepository).deleteById(3L);
    }

    @Test
    void findByLastName() {
        Mockito.when(ownerRepository.findByLastName(Mockito.any())).thenReturn(testOwner2);
        Assertions.assertThat(ownerServiceJpa.findByLastName("Jane")).isEqualTo(testOwner2);
    }
}