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
public class ItemsDAOImpl implements ItemsDAO{

	public class ItemsRowMapper implements RowMapper<Items> {

		@Override
		public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
			Items item = new Items();
			item.setName(rs.getString(1));
			item.setDescription(rs.getString(2));
			item.setUnitPrice(rs.getInt(3));
			item.setId(rs.getInt(4));
			return item;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void deleteItems(int id) {
		String deleteQry = "DELETE FROM ITEMS WHERE ID=?";
		new JdbcTemplate(dataSource).update(deleteQry, id);
	}

	@Override
	public void updateItems(Items item) {
//		int id, String name, String description, double unitPrice
		String updateQry = "UPDATE ITEMS SET NAME = ?, DESCRIPTION = ?, UNTIPRICE = ? WHERE ID = ?";
		new JdbcTemplate(dataSource).update(updateQry, item.getName(),item.getDescription(),item.getUnitPrice(),item.getId());
	}

	@Override
	public void createItems(Items item) {
		String createQry = "INSERT INTO ITEMS (NAME,DESCRIPTION,UNITPRICE) VALUES (?,?,?)";
		new JdbcTemplate(dataSource).update(createQry, item.getName(),item.getDescription(),item.getUnitPrice());
	}

	@Override
	public List<Items> getAllItems() {
		
		// * throws an error -> java.lang.NumberFormatException: For input string: "micheal@mail.com"
		String selectAllQry = "SELECT NAME,DESCRIPTION,UNITPRICE,ID FROM ITEMS";
		return new JdbcTemplate(dataSource).query(selectAllQry, new ItemsRowMapper());
	}

	@Override
	public Items getItems(int id) {
		String selectQry = "SELECT * FROM ITEMS WHERE ID=?";
		return new JdbcTemplate(dataSource).queryForObject(selectQry, new ItemsRowMapper());

	}

	@Override
	public long count(){
		String countQry = "SELECT COUNT(ID) FROM ITEMS";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}
}
