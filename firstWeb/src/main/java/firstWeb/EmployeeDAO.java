package firstWeb;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	
	int firstId() throws SQLException;
	
	int lastId() throws SQLException;
	int nextId(int id) throws SQLException;
	int previousId(int id) throws SQLException;
	
	void deleteEmployee(int i) throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void createEmployee(Employee emp) throws SQLException;

	List<Employee> getAllEmployees() throws SQLException;

	Employee getEmployee(int id) throws SQLException;
	
	public long count() throws SQLException;
	
	 
	List<Employee> getEmployeeByAgeBetween(int age1, int age2) throws SQLException;
	 
	List<Employee> getEmployeeSalaryGreaterThan(int amount) throws SQLException;
	 
	List<Employee> getEmployeeSalaryLesserThan(int amount) throws SQLException;

}
