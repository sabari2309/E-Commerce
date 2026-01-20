package com.avitam.application.dao;

import java.util.List;

import com.avitam.application.model.Address;

public interface AddressDao {
   List<Address> getAddressById(int user_id);

   boolean addAddress(Address address, int user_id);

  Address getByAddressId(int addressId);

}
