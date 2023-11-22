package firstWeb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do get");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter()
				.print("User name = " + request.getParameter("name") + "Password = " + request.getParameter("pass"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		super.doPost(request, response);
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		if(name.length()<4 || pass.length()<8) {
			request.setAttribute("passMessage", pass);
			request.setAttribute("nameMessage", name);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		else {
		if("scott".equals(name) && "rootrootr".equals(pass)) {
			request.setAttribute("message", "Hi Scott, how have you been?");
		}
		else {
			request.setAttribute("message", "Only Scott is a Valid User, GO AWAY");
		}
		
		//will directly take me back to login page
		request.getRequestDispatcher("results.jsp").forward(request, response);
		}
	}

}
