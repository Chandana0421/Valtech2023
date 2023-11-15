package com.valtech.training.firstspringboot.components;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import com.valtech.training.firstspringboot.components.EmployeeDAOImpl.EmployeeRowMapper;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	public class EmployeeRowMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee e = new Employee();
			e.setName(rs.getString(1));
			e.setAge(rs.getInt(2));
			e.setExperience(rs.getInt(3));
			e.setSeniority(rs.getInt(4));
			e.setSalary(rs.getInt(5));
			e.setId(rs.getInt(6));
			return e;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void deleteEmployee(int id) {

		String deleteQry = "DELETE FROM EMPLOYEE WHERE ID=?";
		new JdbcTemplate(dataSource).update(deleteQry, id);
	}

	@Override
	public void updateEmployee(Employee emp) {

		String updateQry = "UPDATE EMPLOYEE SET NAME = ?, AGE = ?, EXPERIENCE = ?, SENIORITY = ?, SALARY = ? WHERE ID = ?";
		new JdbcTemplate(dataSource).update(updateQry, emp.getName(), emp.getAge(), emp.getExperience(),
				emp.getSeniority(), emp.getSalary(), emp.getId());
	}

	@Override
	public void createEmployee(Employee emp) {
		String createQry = "INSERT INTO EMPLOYEE (NAME,AGE,EXPERIENCE,SENIORITY,SALARY) VALUES (?,?,?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry, emp.getName(), emp.getAge(), emp.getExperience(),
				emp.getSeniority(), emp.getSalary());
	}

	@Override
	public List<Employee> getAllEmployees() {
		String selectAllQry = "SELECT NAME,AGE,EXPERIENCE,SENIORITY,SALARY,ID FROM EMPLOYEE";
		return new JdbcTemplate(dataSource).query(selectAllQry, new EmployeeRowMapper());
	}

	@Override
	public Employee getEmployee(int id) {
		String selectQry = "SELECT * FROM EMPLOYEE WHERE ID=?";
		return new JdbcTemplate(dataSource).queryForObject(selectQry, new EmployeeRowMapper());

	}

	@Override
	public long count(){
		String countQry = "SELECT COUNT(ID) FROM EMPLOYEE";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}

}
