package firstWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private int count;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//		super.init(config);
		System.out.println("Init of Hello Servlet");
		System.out.println("Driver CLass = "+config.getInitParameter("driver-class"));
		System.out.println("Jdbc Url = " +config.getInitParameter("jdbc-url"));
		System.out.println("Username ="+config.getInitParameter("username"));
		System.out.println("Password ="+config.getInitParameter("password"));
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
//		super.destroy();
		System.out.println("Destroy of the Hello Servlet Count ="+count);
	}
	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		resp.getWriter().print("Hello World");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Hello Servlet");
		out.print("</title>");
		out.print("<head>");
		out.print("<body>");
		
		out.print("</body>");
		out.print("</html>");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doDelete(req, resp);
		
	}
}
