package firstWeb;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeServlet extends HttpServlet {
	
	private EmployeeDAO dao = new EmployeeDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession sess = req.getSession(true);
//			req.setAttribute("current", dao.firstId());
			sess.setAttribute("current", dao.firstId());
//			sess.setAttribute("emp", dao.getEmployee(dao.firstId()));
			
			req.setAttribute("emp", dao.getEmployee(dao.firstId()));
			System.out.println(req.getAttribute("emp"));
			req.getRequestDispatcher("employee.jsp").forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
//		System.out.println("dopost");
		HttpSession sess = req.getSession();
		int current = (Integer)sess.getAttribute("current");
//		int current = (Integer)req.getAttribute("current");
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
		sess.setAttribute("current", current); //save state, if you dont do this your current won't change
//		sess.setAttribute("emp", dao.getEmployee(current));
		req.setAttribute("emp", dao.getEmployee(current));
		
		req.getRequestDispatcher("employee.jsp").forward(req,resp);
//		
		//using redirect
		
//		resp.sendRedirect("employee.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
