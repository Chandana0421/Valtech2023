package com.training.valtech.springorderassignment.components;

import java.util.List;

public interface AddressDAO {

	void deleteAddress(int id);

	void updateAddress(Address address);

	void createAddress(Address address);

	List<Address> getAllAddresses();

	Address getAddress(int id);

	long count();
}