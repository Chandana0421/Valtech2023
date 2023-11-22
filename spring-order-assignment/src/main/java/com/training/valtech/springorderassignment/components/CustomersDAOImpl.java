package com.training.valtech.springorderassignment.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomersDAOImpl implements CustomersDAO{

	@Autowired
	AddressDAO addressDAO = new AddressDAOImpl();
	@Autowired
	OrdersDAO ordersDAO = new OrdersDAOImpl();
	public class CustomerRowMapper implements RowMapper<Customers> {

		@Override
		public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customers customer = new Customers();
			customer.setName(rs.getString(1));
			customer.setEmail(rs.getString(2));
			customer.setAge(rs.getInt(3));
			customer.setPhoneNumber(rs.getString(4));
			customer.setAddress_id(rs.getInt(5));
			customer.setId(rs.getInt(6));
			return customer;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void deleteCustomer(int id) {

		String deleteQry = "DELETE FROM CUSTOMERS WHERE ID=?";
		new JdbcTemplate(dataSource).update(deleteQry, id);
	}

	@Override
	public void updateCustomer(Customers customer) {
		String updateQry = "UPDATE CUSTOMERS SET NAME = ?, EMAIL = ?, AGE = ?, PHONENUMBER = ?,ADDRESS_ID = ? WHERE ID = ?";
		new JdbcTemplate(dataSource).update(updateQry, customer.getName(), customer.getEmail(), customer.getAge(), customer.getPhoneNumber(),customer.getAddress_id(), customer.getId());
	}

	@Override
	public void createCustomer(Customers customer) {
		String createQry = "INSERT INTO CUSTOMERS (NAME,EMAIL,AGE,PHONENUMBER,ADDRESS_ID) VALUES (?,?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry, customer.getName(), customer.getEmail(), customer.getAge(),customer.getAddress_id(), customer.getPhoneNumber());
	}

	@Override
	public List<Customers> getAllCustomers() {
		
		// * throws an error -> java.lang.NumberFormatException: For input string: "micheal@mail.com"
		String selectAllQry = "SELECT NAME,EMAIL,AGE,PHONENUMBER,ADDRESS_ID,ID FROM CUSTOMERS";
		return new JdbcTemplate(dataSource).query(selectAllQry, new CustomerRowMapper());
	}

	@Override
	public Customers getCustomers(int id) {
		String selectQry = "SELECT NAME,EMAIL,AGE,PHONENUMBER,ADDRESS_ID,ID FROM CUSTOMERS WHERE ID = ?";
		return new JdbcTemplate(dataSource).queryForObject(selectQry, new CustomerRowMapper(), id);

	}

	@Override
	public long count(){
		String countQry = "SELECT COUNT(ID) FROM CUSTOMERS";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}

	@Override
	public Address getCustomerAddress(Customers customer) {
		return addressDAO.getAddress(customer.getAddress_id());
	}

	@Override
	public List<Orders> getOrderForCustomers(Customers customer) {
		// TODO Auto-generated method stub
		return ordersDAO.getOrdersByCustomerId(customer.getId());
	}
	
}
