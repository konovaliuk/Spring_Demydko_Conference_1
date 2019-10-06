package one.persistence.repositories;

import one.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByCityAndStreetAndBuildingAndRoom(String city, String street, String building, String room);
}
