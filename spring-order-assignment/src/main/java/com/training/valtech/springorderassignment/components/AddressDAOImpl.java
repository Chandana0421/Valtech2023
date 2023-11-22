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
public class AddressDAOImpl implements AddressDAO {

	public class AddressRowMapper implements RowMapper<Address> {

		@Override
		public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
			Address address = new Address();
			address.setStreet(rs.getString(1));
			address.setCity(rs.getString(2));
			address.setState(rs.getString(3));
			address.setZipCode(rs.getInt(4));
			address.setId(rs.getInt(5));
			return address;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void deleteAddress(int id) {

		String deleteQry = "DELETE FROM ADDRESS WHERE ID=?";
		new JdbcTemplate(dataSource).update(deleteQry, id);
	}

	@Override
	public void updateAddress(Address address) {
		String updateQry = "UPDATE ADDRESS SET STREET = ?, CITY = ?, STATE = ?, ZIPCODE = ? WHERE ID = ?";
		new JdbcTemplate(dataSource).update(updateQry, address.getStreet(), address.getCity(), address.getState() ,address.getZipCode(),address.getId());
	}

	@Override
	public void createAddress(Address address) {
		String createQry = "INSERT INTO ADDRESS (STREET,CITY,STATE,ZIPCODE) VALUES (?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry, address.getStreet(), address.getCity(), address.getState() ,address.getZipCode());
	}

	@Override
	public List<Address> getAllAddresses() {
		String selectAllQry = "SELECT STREET,CITY,STATE,ZIPCODE,ID FROM ADDRESS";
		return new JdbcTemplate(dataSource).query(selectAllQry, new AddressRowMapper());
	}

	@Override
	public Address getAddress(int id) {
		String selectQry = "SELECT STREET,CITY,STATE,ZIPCODE,ID FROM ADDRESS WHERE ID=?";
		return new JdbcTemplate(dataSource).queryForObject(selectQry, new AddressRowMapper(),id);

	}

	@Override
	public long count(){
		String countQry = "SELECT COUNT(ID) FROM ADDRESS";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}
	
}
