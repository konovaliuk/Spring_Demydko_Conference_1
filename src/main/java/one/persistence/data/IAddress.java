package one.persistence.data;

import one.persistence.entity.Address;

/**
 * Used for access to data base
 */
public interface IAddress {
    Address findAddress(String city, String street, String building, String room);
    Address saveAddress(Address address);
}
