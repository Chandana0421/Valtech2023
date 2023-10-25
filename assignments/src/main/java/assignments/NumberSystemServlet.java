package assignments;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NumberSystemServlet
 */
public class NumberSystemServlet extends HttpServlet {

    public NumberSystemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number1 = Integer.parseInt(request.getParameter("number1"));
        int number2 = Integer.parseInt(request.getParameter("number2"));
        String operation = request.getParameter("operation");
        String toSystem = request.getParameter("toSystem");
        String result;
        int operationResult = 0;

        if("Add".equals(operation)) {
        	operationResult = number1 + number2;
            
        }
        else if("Sub".equals(operation)){
        	operationResult = number1 - number2;
        }
        
        switch (toSystem) {
        case "binary":
            result = Integer.toBinaryString(operationResult);
            break;
        case "decimal":
            result = Integer.toString(operationResult);
            break;
        case "hexadecimal":
            result = Integer.toHexString(operationResult).toUpperCase();
            break;
        case "octal":
            result = Integer.toOctalString(operationResult);
            break;
            
        default:
            result = "Invalid";
            break;
    }
        
        request.setAttribute("result", result);
        request.setAttribute("decimalResult", operationResult);
        request.getRequestDispatcher("numberSystemResult.jsp").forward(request, response);

	}

}
