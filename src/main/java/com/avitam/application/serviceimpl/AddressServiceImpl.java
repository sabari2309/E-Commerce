package com.avitam.application.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.avitam.application.dao.AddressDao;
import com.avitam.application.model.Address;
import com.avitam.application.service.AddressService;

public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressDao addressDao;

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Override
	public List<Address> getAddressByUserId(int user_id) {
		return addressDao.getAddressById(user_id);
	}

	@Override
	public boolean addAddress(Address address) {
        return addressDao.addAddress(address,address.getUser_id());
         
	}

	@Override
	public Address getAddressById(int address_id) {
		return addressDao.getByAddressId(address_id);
	}

}
