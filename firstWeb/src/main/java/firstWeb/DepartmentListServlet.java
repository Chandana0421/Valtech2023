package firstWeb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DepartmentListServlet extends HttpServlet {
	
	private DepartmentDAO dao = new DepartmentDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession sess = req.getSession(true);

			sess.setAttribute("current", dao.firstId());
			
			req.setAttribute("dept", dao.getDepartment(dao.firstId()));
			req.setAttribute("emp", dao.getEmployeesByDepartment(dao.firstId()));
			System.out.println(req.getAttribute("emp"));
			req.getRequestDispatcher("departmentEmployeeList.jsp").forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		int current = (Integer)sess.getAttribute("current");
		String submit = req.getParameter("submit"); //name of the button - submit
		try {
		if("First".equals(submit)) {
			current = dao.firstId();
		}else if("Last".equals(submit)) {
			current = dao.lastId();
		}else if("Next".equals(submit)) {
			current = dao.nextId(current);
		}else if("Previous".equals(submit)) {
			current = dao.previousId(current);
		}
		sess.setAttribute("current", current); 
		req.setAttribute("dept", dao.getDepartment(current));
		req.setAttribute("emp", dao.getEmployeesByDepartment(current));
		
		req.getRequestDispatcher("departmentEmployeeList.jsp").forward(req,resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
