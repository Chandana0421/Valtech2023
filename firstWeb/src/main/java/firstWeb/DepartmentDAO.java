package firstWeb;

import java.sql.SQLException;
import java.util.List;


public interface DepartmentDAO {

	void deleteDepartment(int deptid) throws SQLException;

	void updateDepartment(Department dept) throws SQLException;

	void createDepartment(Department dept) throws SQLException;

	List<Department> getAllDepartments() throws SQLException;

	List<Employee> getEmployeesByDepartment(int deptId) throws SQLException;
	
	List<Employee> getEmployeeByLocation(String location) throws SQLException;
	Department getDepartment(int deptid) throws SQLException;
	
	public long count() throws SQLException;

	int firstId() throws SQLException;

	int lastId() throws SQLException;

	int nextId(int id) throws SQLException;

	int previousId(int id) throws SQLException;
}
