package com.training.valtech.springorderassignment.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class OrdersDAOImpl implements OrdersDAO{

	@Autowired
	OrderDescriptionDAO orderDescriptionDAO = new OrderDescriptionDAOImpl();
	
	public class OrdersRowMapper implements RowMapper<Orders> {

		@Override
		public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
			Orders order = new Orders();
			order.setDate(rs.getDate(1));
			order.setCustomer_id(rs.getInt(2));
			order.setId(rs.getInt(3));
			return order;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void deleteOrder(int id) {
		String deleteQry = "DELETE FROM ORDERS WHERE ID=?";
		new JdbcTemplate(dataSource).update(deleteQry, id);
	}

	@Override
	public void updateOrders(Orders order) {
		String updateQry = "UPDATE ORDERS SET DATE = ?, CUSTOMER_ID=? WHERE ID = ?";
		new JdbcTemplate(dataSource).update(updateQry, order.getDate(),order.getCustomer_id(), order.getId());
	}

	@Override
	public void createOrders(Orders order) {
		String createQry = "INSERT INTO ORDERS (DATE,CUSTOMER_ID) VALUES (?,?)";
		new JdbcTemplate(dataSource).update(createQry, order.getDate(), order.getCustomer_id());
	}

	@Override
	public List<Orders> getAllOrders() {
		String selectAllQry = "SELECT DATE,CUSTOMER_ID,ID FROM ORDERS";
		return new JdbcTemplate(dataSource).query(selectAllQry, new OrdersRowMapper());
	}

	@Override
	public Orders getOrders(int id) {
		String selectQry = "SELECT * FROM ORDERS WHERE ID=?";
		return new JdbcTemplate(dataSource).queryForObject(selectQry, new OrdersRowMapper());

	}

	@Override
	public long count(){
		String countQry = "SELECT COUNT(ID) FROM ORDERS";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}

	@Override
	public List<OrderDescription> getOrderDescriptionsForOrder(Orders order) {
		return orderDescriptionDAO.getAllOrderDescriptionByOrderId(order.getId());
	}

	@Override
	public List<Orders> getOrdersByCustomerId(int customer_id) {
		String selectAllQry = "SELECT DATE,CUSTOMER_ID,ID FROM ORDERS WHERE ID=?";
		return new JdbcTemplate(dataSource).query(selectAllQry, new OrdersRowMapper(),customer_id);
	}
	

}
