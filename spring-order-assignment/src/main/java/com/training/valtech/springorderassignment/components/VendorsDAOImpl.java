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
public class VendorsDAOImpl implements VendorsDAO{
	@Autowired
	AddressDAO addressDAO = new AddressDAOImpl();
	public class VendorsRowMapper implements RowMapper<Vendors> {

		@Override
		public Vendors mapRow(ResultSet rs, int rowNum) throws SQLException {
			Vendors vendor = new Vendors();
			vendor.setName(rs.getString(1));
			vendor.setAddress_id(rs.getInt(2));
			vendor.setId(rs.getInt(3));
			return vendor;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void deleteVendor(int id) {
		String deleteQry = "DELETE FROM VENDORS WHERE ID=?";
		new JdbcTemplate(dataSource).update(deleteQry, id);
	}

	@Override
	public void updateVendors(Vendors vendor) {
		String updateQry = "UPDATE ITEMS SET NAME = ?,ADDRESS_ID WHERE ID = ?";
		new JdbcTemplate(dataSource).update(updateQry, vendor.getName(),vendor.getAddress_id(), vendor.getId());
	}

	@Override
	public void Vendors(Vendors vendor) {
		String createQry = "INSERT INTO VENDOR (NAME,ADDRESS_ID) VALUES (?)";
		new JdbcTemplate(dataSource).update(createQry,vendor.getAddress_id(), vendor.getName());
	}

	@Override
	public List<Vendors> getAllVendors() {
		String selectAllQry = "SELECT NAME,ADDRESS_ID,ID FROM VENDORS";
		return new JdbcTemplate(dataSource).query(selectAllQry, new VendorsRowMapper());
	}

	@Override
	public Vendors getVendors(int id) {
		String selectQry = "SELECT NAME,ADDRESS_ID,ID FROM VENDORS WHERE ID=?";
		return new JdbcTemplate(dataSource).queryForObject(selectQry, new VendorsRowMapper(),id);

	}

	@Override
	public long count(){
		String countQry = "SELECT COUNT(ID) FROM VENDORS";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);

	}

	@Override
	public Address getVendorAddress(Vendors vendor) {
		return addressDAO.getAddress(vendor.getId());
	}
	
}