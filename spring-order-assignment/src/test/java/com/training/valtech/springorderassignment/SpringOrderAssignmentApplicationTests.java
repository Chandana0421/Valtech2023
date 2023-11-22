package com.training.valtech.springorderassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.valtech.springorderassignment.components.Address;
import com.training.valtech.springorderassignment.components.AddressDAO;
import com.training.valtech.springorderassignment.components.Customers;
import com.training.valtech.springorderassignment.components.CustomersDAO;
import com.training.valtech.springorderassignment.components.ItemsDAO;
import com.training.valtech.springorderassignment.components.OrderDescriptionDAO;
import com.training.valtech.springorderassignment.components.OrdersDAO;
import com.training.valtech.springorderassignment.components.Vendors;
import com.training.valtech.springorderassignment.components.VendorsDAO;

@SpringBootTest
class SpringOrderAssignmentApplicationTests {

	@Autowired
	AddressDAO addressDao;
	
	@Autowired
	CustomersDAO customersDAO;
	@Autowired
	ItemsDAO itemsDAO;
	
	@Autowired
	VendorsDAO vendorsDAO;
	
	@Autowired
	OrdersDAO ordersDAO;
	
	@Autowired
	OrderDescriptionDAO orderDescriptionDAO;
	@Test
	private void testAddress() {
		System.out.println("fyyrbyhyhtrhtrtrgtgrs");
		assertEquals(4, addressDao.count());
		assertEquals(4, addressDao.getAllAddresses().size());
	}
	
	@Test
	private void testCustomers() {
		assertEquals(1, customersDAO.count());
		assertEquals(1, customersDAO.getAllCustomers().size());
	}
	@Test
	private void testItems() {
		assertEquals(3, itemsDAO.count());
		assertEquals(3, itemsDAO.getAllItems().size());
	}
	
	@Test
	void testVendors() {
		assertEquals(3, vendorsDAO.count());
		assertEquals(3, vendorsDAO.getAllVendors().size());
	}
	
	@Test
	private void testOrders() {
		assertEquals(1, ordersDAO.count());
		assertEquals(1, ordersDAO.getAllOrders().size());
	}
	
	@Test
	private void testOrderDescription() {
		assertEquals(1, orderDescriptionDAO.count());
		assertEquals(1, orderDescriptionDAO.getAllOrderDescriptions().size());
	}
	
	@Test
	private void CustomerAddressMapping() {
		Customers customer = customersDAO.getCustomers(1);
		Address address = addressDao.getAddress(1);
		assertEquals(address, customersDAO.getCustomerAddress(customer));
	}
	
	@Test
	private void VendorAddressMapping(){
		Vendors vendors = vendorsDAO.getVendors(1);
		Address address = addressDao.getAddress(2);
		assertEquals(address, vendorsDAO.getVendorAddress(vendors));
	}
}
