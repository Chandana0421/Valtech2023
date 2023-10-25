package com.valtech.training.day4;

import com.valtech.training.day4.Department;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.valtech.training.day3.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void deleteEmployee(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated "+rowsUpdated);
		con.close();
	}

	@Override
	public void updateEmployee(Employee emp) throws SQLException{
		Connection con  = getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE EMPLOYEE SET NAME = ?, AGE = ?, EXPERIENCE = ?, SENIORITY = ?, SALARY = ?, DEPTID=? WHERE ID = ?");
		populatePreparedStatementFromEmployee(emp, ps);
		ps.setInt(7, emp.getId());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated "+rowsUpdated);
		con.close();
	}

	@Override
	public void createEmployee(Employee emp) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPTID) VALUES (?,?,?,?,?,?)");
		populatePreparedStatementFromEmployee(emp, ps);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows updated" + rowsUpdated);
	}

	private void populatePreparedStatementFromEmployee(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setString(1, emp.getName());
		ps.setInt(2,emp.getAge());
		ps.setInt(3, emp.getExperience());
		ps.setInt(4,emp.getSeniority());
		ps.setInt(5, emp.getSalary());
		ps.setInt(6, emp.getDeptId());
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT NAME,AGE,EXPERIENCE,SENIORITY,SALARY,ID,DEPTID FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		List<Employee> emp = new ArrayList<>();
		while (rs.next()) {
			emp.add(mapRowToEmployee(rs));
		}
		con.close();
		return emp;
	}

	@Override
	public Employee getEmployee(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id); // now it's gonna be where id=1,2,3,4 and so on
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Employee e = mapRowToEmployee(rs);
			con.close();
			return e;
		} else {
			System.out.println("no row with id - " + id + " found....");
			return null;
		}

	}

	private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		 // INDEX STARTS FROM 1
		e.setName(rs.getString(1));
		e.setAge(rs.getInt(2));
		e.setExperience(rs.getInt(3));
		e.setSeniority(rs.getInt(4));
		e.setSalary(rs.getInt(5));
		e.setId(rs.getInt(6));
		e.setDeptId(rs.getInt(7));
		return e;
	}


	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false", "root", "root");
	}
	
	@Override
	public long count() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT COUNT(ID) FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
		long result = rs.getLong(1);
		return result;
		}else {
		return 0;
		}
	}

	public static void main(String[] args) throws SQLException {
		EmployeeDAO dao = new EmployeeDAOImpl();
		
//		GET ONE EMPLOYEE DEETS
		System.out.println(dao.getEmployee(1));
		System.out.println(dao.getEmployee(2));
		
		//CREATE EMPLOYEE 
//		dao.createEmployee(new Employee(4,12,25,"xyz",75000));
		
		
		//UPDATE EMPLOYEE
//		Employee e = dao.getEmployee(3);
//		e.setSeniority(5);
//		dao.updateEmployee(e);		
		
		//DELETE EMPLOYEE
//		dao.deleteEmployee(3);
		
//		long res = dao.count();
//		System.out.println("Count " + res);
		System.out.println(dao.getAllEmployees());

	}

	@Override
	public void getListOfEmployeeinEachDepartment() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getEmployeeByDeptLocation(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeeByDeptName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeeAgeBetween(int min, int max) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeeBySeniority(int limitVal) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeeSalaryGreater(int amount) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeeSalaryLesser(int amount) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
