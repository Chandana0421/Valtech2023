package firstWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DepartmentDAOImpl implements DepartmentDAO{

	@Override
	public void deleteDepartment(int deptid) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM DEPARTMENT WHERE DEPTID=?");
		ps.setInt(1, deptid);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated "+rowsUpdated);
		con.close();
	}

	@Override
	public void updateDepartment(Department dept) throws SQLException {
		Connection con  = getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE DEPARTMENT SET DEPTID = ?, NAME = ?, LOCATION=? WHERE DEPTID = ?");
		populatePreparedStatementFromDepartment(dept, ps);
		ps.setInt(4, dept.getId());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated "+rowsUpdated);
		con.close();
		
	}

	@Override
	public void createDepartment(Department dept) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO DEPARTMENT (DEPTID,NAME,LOCATION) VALUES (?,?,?)");
		populatePreparedStatementFromDepartment(dept, ps);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows updated" + rowsUpdated);
		con.close();
	}

	private void populatePreparedStatementFromDepartment(Department dept, PreparedStatement ps) throws SQLException {
		ps.setInt(1, dept.getId());
		ps.setString(2,dept.getName());
		ps.setString(3, dept.getLocation());
		
	}

	@Override
	public List<Department> getAllDepartments() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT * FROM DEPARTMENT");
		ResultSet rs = ps.executeQuery();
		List<Department> dept = new ArrayList<>();
		while (rs.next()) {
			dept.add(mapRowToDepartment(rs));
		}
		con.close();
		return dept;
	}

	@Override
	public Department getDepartment(int deptid) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT * FROM DEPARTMENT WHERE DEPTID=?");
		ps.setInt(1, deptid); // now it's gonna be where id=1,2,3,4 and so on
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Department d = mapRowToDepartment(rs);
			con.close();
			return d;
		} else {
			System.out.println("no row with id - " + deptid + " found....");
			return null;
		}
	}

	private Department mapRowToDepartment(ResultSet rs) throws SQLException {
		Department d = new Department();
		 // INDEX STARTS FROM 1
		d.setId(rs.getInt(1));
		d.setName(rs.getString(2));
		d.setLocation(rs.getString(3));
		return d;
	}
	
	@Override
	public List<Employee> getEmployeesByDepartment(int deptId) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("select * from employee where deptId in (select deptId from department where deptId=?)");
		ps.setInt(1, deptId);
		ResultSet rs = ps.executeQuery();
		List<Employee> empList = new ArrayList<>();
		while (rs.next()) {
			empList.add(mapRowToEmployee(rs));
		}
		con.close();
		return empList;
	}
	
	@Override
	public List<Employee> getEmployeeByLocation(String location) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("select * from employee where deptId in (select deptId from department where location=?)");
		ps.setString(1, location);
		ResultSet rs = ps.executeQuery();
		List<Employee> empList = new ArrayList<>();
		while (rs.next()) {
			empList.add(mapRowToEmployee(rs));
		}
		con.close();
		return empList;
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
	
	@Override
	public long count() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT COUNT(DEPTID) FROM DEPARTMENT");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
		long result = rs.getLong(1);
		return result;
		}else {
		return 0;
		}
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
	public int firstId() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT MIN(DEPTID) FROM DEPARTMENT");
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
		PreparedStatement ps = con.prepareStatement("SELECT MAX(DEPTID) FROM DEPARTMENT");
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
		PreparedStatement ps = con.prepareStatement("SELECT MIN(DEPTID) FROM DEPARTMENT WHERE deptId > ?");
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
		PreparedStatement ps = con.prepareStatement("SELECT MAX(DEPTID) FROM DEPARTMENT WHERE deptId < ?");
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
		DepartmentDAO deptdao = new DepartmentDAOImpl();
//		System.out.println(deptdao.getDepartment(101));
		System.out.println(deptdao.getAllDepartments());
		
//		long res = deptdao.count();
//		System.out.println("Count " + res);
		
		//CREATE EMPLOYEE 
//		deptdao.createDepartment(new Department(103,"xyz","loc"));

		//UPDATE 

//		Department d = deptdao.getDepartment(103);
//		d.setLocation("kyoto");
//		deptdao.updateDepartment(d);	
	
		
		//DELETE EMPLOYEE
//		deptdao.deleteDepartment(103);
//		System.out.println(deptdao.getAllDepartments());
		
//		System.out.println(deptdao.getEmployeeByDepartment(102));
		
//		System.out.println(deptdao.getEmployeeByLocation("tokyo"));
		
//		System.out.println(deptdao.lastId());
	}



}

