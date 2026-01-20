package com.avitam.application.service;

import java.util.List;

import com.avitam.application.model.Address;

public interface AddressService {
    List<Address> getAddressByUserId(int user_id);
    Address getAddressById(int address_id);
	boolean addAddress(Address address);
}
