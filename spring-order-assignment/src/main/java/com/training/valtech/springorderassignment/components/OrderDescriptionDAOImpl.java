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
public class OrderDescriptionDAOImpl implements OrderDescriptionDAO {

	public class OrderDescriptionRowMapper implements RowMapper<OrderDescription> {

		@Override
		public OrderDescription mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderDescription orderDesc = new OrderDescription();
			orderDesc.setOrder_id(rs.getInt(1));
			orderDesc.setItem_id(rs.getInt(2));
			orderDesc.setQuantity(rs.getInt(3));
			orderDesc.setId(rs.getInt(4));
			return orderDesc;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void deleteOrderDescription(int id) {
		String deleteQry = "DELETE FROM ORDERDESCRIPTION WHERE ID=?";
		new JdbcTemplate(dataSource).update(deleteQry, id);
	}

	@Override
	public void updateOrderDescription(OrderDescription orderDesc) {
		String updateQry = "UPDATE ORDERDESCRIPTION SET ORDER_ID = ?, ITEM_ID=?,QUANTITY WHERE ID = ?";
		new JdbcTemplate(dataSource).update(updateQry, orderDesc.getOrder_id(),orderDesc.getItem_id(), orderDesc.getQuantity(),orderDesc.getId());
	}

	@Override
	public void createOrderDescription(OrderDescription orderDesc) {
		String createQry = "INSERT INTO ORDERDESCRIPTION (ORDER_ID,ITEM_ID,QUANTITY) VALUES (?,?,?)";
		new JdbcTemplate(dataSource).update(createQry, orderDesc.getOrder_id(), orderDesc.getItem_id(), orderDesc.getQuantity());
	}

	@Override
	public List<OrderDescription> getAllOrderDescriptions() {
		String selectAllQry = "SELECT ORDER_ID,ITEM_ID,QUANTITY,ID FROM ORDERDESCRIPTION";
		return new JdbcTemplate(dataSource).query(selectAllQry, new OrderDescriptionRowMapper());
	}

	@Override
	public OrderDescription getOrderDescription(int id) {
		String selectQry = "SELECT * FROM ORDERDESCRIPTION WHERE ID=?";
		return new JdbcTemplate(dataSource).queryForObject(selectQry, new OrderDescriptionRowMapper(),id);

	}

	@Override
	public long count(){
		String countQry = "SELECT COUNT(ID) FROM ORDERDESCRIPTION";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}

	@Override
	public List<OrderDescription> getAllOrderDescriptionByOrderId(int order_id) {
		String selectQry = "SELECT * FROM ORDERDESCRIPTION WHERE ORDER_ID=?";
		return new JdbcTemplate(dataSource).query(selectQry, new OrderDescriptionRowMapper(),order_id);
	}
	
}
