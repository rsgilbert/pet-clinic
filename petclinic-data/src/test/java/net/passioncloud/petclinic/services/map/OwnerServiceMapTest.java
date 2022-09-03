package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.model.Owner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    Owner testOwner1;
    Owner testOwner2;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap();
        testOwner1 = Owner.builder()
                .city("Kampala")
                .address("Kamwokya")
                .telephone("04224")
                .build();
        testOwner1.setId(100L);
        testOwner1.setFirstName("Mukisa");
        testOwner1.setLastName("Gloria");
        testOwner2 = Owner.builder()
                .address("Ntinda")
                .city("Nakawa")
                .telephone("765")
                .build();
        testOwner2.setFirstName("Jimmy");
        testOwner2.setLastName("Mulokole");
        ownerServiceMap.save(testOwner1);

    }

    @Test
    void findById() {
        Owner o = ownerServiceMap.findById(100L);
        Assertions.assertThat(o.getLastName()).isEqualTo("Gloria");
    }

    @Test
    void save() {
        Owner savedOwner = ownerServiceMap.save(testOwner2);
        Assertions.assertThat(ownerServiceMap.findAll()).hasSize(2);
        Assertions.assertThat(savedOwner).isNotNull();
        Assertions.assertThat(savedOwner.getId()).isNotNull();
    }

    @Test
    void delete() {
        ownerServiceMap.delete(testOwner1);
        Assertions.assertThat(ownerServiceMap.findAll()).isEmpty();
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(100L);
        Assertions.assertThat(ownerServiceMap.findAll()).isEmpty();
    }

    @Test
    void findAll() {
        Owner firstOwner = ownerServiceMap.findAll().stream().findFirst().orElseThrow();
        Assertions.assertThat(ownerServiceMap.findAll()).hasSize(1);
        Assertions.assertThat(firstOwner.getId()).isEqualTo(100L);
    }

    @Test
    void findByLastName() {
        ownerServiceMap.save(testOwner2);
        Owner o1 = ownerServiceMap.findByLastName("Gloria");
        Assertions.assertThat(o1.getFirstName()).isEqualTo("Mukisa");

        Owner o2 = ownerServiceMap.findByLastName("Mulokole");
        Assertions.assertThat(o2.getFirstName()).isEqualTo("Jimmy");

        Assertions.assertThat(ownerServiceMap.findByLastName("XXX")).isNull();
    }
}