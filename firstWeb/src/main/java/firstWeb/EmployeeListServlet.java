package firstWeb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeListServlet extends HttpServlet {

	private EmployeeDAO dao = new EmployeeDAOImpl();

	public EmployeeListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession sess = req.getSession(true);

			req.setAttribute("emp", dao.getAllEmployees());

			System.out.println(req.getAttribute("emp"));
//			resp.sendRedirect("employeeList.jsp");
			req.getRequestDispatcher("employeeList.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(true);
//		int current = (Integer)sess.getAttribute("currentId");

		String submit = req.getParameter("submit");

		
//		Employee curEmp = null;
		try {

			if ("View".equals(submit)) {
				int empId = Integer.parseInt(req.getParameter("empId"));
				sess.setAttribute("currentId", empId);
				System.out.println(empId);
				req.setAttribute("emp", dao.getEmployee(empId));
				req.getRequestDispatcher("viewEmployee.jsp").forward(req, resp);
				
		} 
//				else if ("Edit".equals(submit)) {
////				req.setAttribute("emp", dao.getEmployee(empId));
////				req.getRequestDispatcher("editOrCreateEmployee.jsp").forward(req, resp);
////				
//			} 
				else if ("Delete".equals(submit)) {
					int empId = Integer.parseInt(req.getParameter("empId"));
					sess.setAttribute("currentId", empId);
					System.out.println(empId);
				dao.deleteEmployee(empId);
				req.setAttribute("emp", dao.getAllEmployees());
				req.getRequestDispatcher("employeeList.jsp").forward(req, resp);
				
			}
				else if("CreateNewEmployee".equals(submit)) {
					sess.setAttribute("currentId", -1); 
					req.getRequestDispatcher("editOrCreateEmployee.jsp").forward(req, resp);
//					Employee employee = new Employee();
					System.out.println("-------------------------------------");
					System.out.println(req.getParameter("empId"));
					System.out.println("-------------------------------------");
					
//					employee.setId((Integer)req.getAttribute("empId"));
//					employee.setAge((Integer)req.getAttribute("age"));
//					employee.setName((String)req.getAttribute("name"));
//					employee.setSeniority((Integer)req.getAttribute("seniority"));
//					employee.setSalary((Integer)req.getAttribute("salary"));
//					employee.setExperience((Integer)req.getAttribute("experience"));
//					employee.setDeptId((Integer)req.getAttribute("deptId"));
//					dao.createEmployee(employee);
//					System.out.println("-------------------------------------");
//					System.out.println(dao.getAllEmployees());
//					System.out.println("-------------------------------------");
//					req.setAttribute("emp", dao.getAllEmployees());
//					req.getRequestDispatcher("employeeList.jsp").forward(req, resp);
				}
//			sess.setAttribute("current", currentId); //here we set current to current

//			resp.sendRedirect("employeeList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
