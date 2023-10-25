package firstWeb;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TimerFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Do Filter of counter filter");
		long startTime = System.currentTimeMillis();
		chain.doFilter(request,response);
		long endTime = System.currentTimeMillis();
		long timeDiffernce = endTime - startTime;
		System.out.println("time differnce taken toprocess the process the request was :"+timeDiffernce+"ms");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init of Timer filter");
	
		
		this.filterConfig= filterConfig;
 
        // Perform any initialization tasks here
        String initializationParameter = filterConfig.getInitParameter("myInitParameter");
        if (initializationParameter != null) {
            System.out.println("Initialization parameter: " + initializationParameter);
            
//            This line retrieves an initialization parameter named "myInitParameter" from the FilterConfig object
//          using the getInitParameter method
	}

}}
