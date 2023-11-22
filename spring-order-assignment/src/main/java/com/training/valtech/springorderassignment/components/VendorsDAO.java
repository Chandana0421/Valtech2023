package com.training.valtech.springorderassignment.components;

import java.util.List;

public interface VendorsDAO {

	void deleteVendor(int id);

	void updateVendors(Vendors vendor);

	void Vendors(Vendors vendor);

	List<Vendors> getAllVendors();

	Vendors getVendors(int id);

	long count();
	Address getVendorAddress(Vendors vendor);
}