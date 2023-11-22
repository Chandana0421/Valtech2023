package firstWeb;

//import com.valtech.training.day4.Department;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void deleteEmployee(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated " + rowsUpdated);
		con.close();
	}

	@Override
	public void updateEmployee(Employee emp) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(
				"UPDATE EMPLOYEE SET NAME = ?, AGE = ?, EXPERIENCE = ?, SENIORITY = ?, SALARY = ?, DEPTID=? WHERE ID = ?");
		populatePreparedStatementFromEmployee(emp, ps);
		ps.setInt(7, emp.getId());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated " + rowsUpdated);
		con.close();
	}

	@Override
	public void createEmployee(Employee emp) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO EMPLOYEE (ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPTID) VALUES (?,?,?,?,?,?,?)");
		populatePreparedStatementFromEmployee(emp, ps);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows updated" + rowsUpdated);
	}

	private void populatePreparedStatementFromEmployee(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setInt(1,emp.getId());
		ps.setString(2, emp.getName());
		ps.setInt(3, emp.getAge());
		ps.setInt(4, emp.getExperience());
		ps.setInt(5, emp.getSeniority());
		ps.setInt(6, emp.getSalary());
		ps.setInt(7, emp.getDeptId());
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
	
	public List<Employee> getEmployeeByAgeBetween(int age1, int age2) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT * FROM EMPLOYEE WHERE AGE BETWEEN ? AND ?");
		ps.setInt(1, age1);
		ps.setInt(2, age2); // now it's gonna be where id=1,2,3,4 and so on
		ResultSet rs = ps.executeQuery();
		List<Employee> emp = new ArrayList<>(); 
		while (rs.next()) {
			emp.add(mapRowToEmployee(rs)); 
		} 
		con.close();
		return emp;
		}
	
	@Override
	public List<Employee> getEmployeeSalaryGreaterThan(int amount) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT * FROM EMPLOYEE WHERE SALARY>?");
		ps.setInt(1, amount); // now it's gonna be where id=1,2,3,4 and so on
		ResultSet rs = ps.executeQuery();
		List<Employee> emp = new ArrayList<>(); 
		while (rs.next()) {
			emp.add(mapRowToEmployee(rs)); 
		} 
		con.close();
		return emp;
		}

	@Override
	public List<Employee> getEmployeeSalaryLesserThan(int amount) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT * FROM EMPLOYEE WHERE SALARY<?");
		ps.setInt(1, amount);
		ResultSet rs = ps.executeQuery();
		List<Employee> emp = new ArrayList<>(); 
		while (rs.next()) {
			emp.add(mapRowToEmployee(rs)); 
		} 
		con.close();
		return emp;
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
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");
	}

	@Override
	public long count() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT COUNT(ID) FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			long result = rs.getLong(1);
			return result;
		} else {
			return 0;
		}
	}


	@Override
	public int firstId() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT MIN(ID) FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int id= rs.getInt(1);
			con.close();
			return id;
		}
//		con.close();
		return 0;
	}

	@Override
	public int lastId() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT MAX(ID) FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int id= rs.getInt(1);
			con.close();
			return id;
		}
//		con.close();
		return 0;
	}

	@Override
	public int nextId(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT MIN(ID) FROM EMPLOYEE WHERE id > ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		int id1=0;
		if (rs.next()) {
			id1= rs.getInt(1); 
			con.close();
		}
		con.close();
		return id1 == 0? lastId(): id1;
	}

	@Override
	public int previousId(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT MAX(ID) FROM EMPLOYEE WHERE id < ?");
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		int id1=0;
		if (rs.next()) {
			id1= rs.getInt(1);
			con.close();
		}
		con.close();
		return id1 == 0? firstId(): id1;
	}
	
	public static void main(String[] args) throws SQLException {
		EmployeeDAO dao = new EmployeeDAOImpl();

		// GET ONE EMPLOYEE DEETS
//		System.out.println(dao.getEmployee(1));
//		System.out.println(dao.getEmployee(2));

		// CREATE EMPLOYEE
//		dao.createEmployee(new Employee(4,12,25,"xyz",75000));

		// UPDATE EMPLOYEE
//		Employee e = dao.getEmployee(3);
//		e.setSeniority(5);
//		dao.updateEmployee(e);		

		// DELETE EMPLOYEE
//		dao.deleteEmployee(3);

//		long res = dao.count();
//		System.out.println("Count " + res);
//		System.out.println(dao.getEmployeeByAgeBetween(20,50));
		
		System.out.println(dao.getEmployeeSalaryLesserThan(100000));

	}


}
