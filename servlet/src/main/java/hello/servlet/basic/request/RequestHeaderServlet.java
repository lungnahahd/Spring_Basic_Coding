package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException
	{
		printStartLine(req);
	}
	
	private void printStartLine(HttpServletRequest request)
	{
		
		System.out.println("--- REQUEST-LINE - START ---");
		
		System.out.println("request.getMethod() = "  + request.getMethod()); 
		System.out.println("request.getProtocal() = " + request.getProtocol());
		System.out.println("request.getScheme() = " + request.getScheme());
		
		System.out.println("request.getRequestURL() = " + request.getRequestURL());
		System.out.println("request.getRequestURI() = " + request.getRequestURI());
		
		System.out.println("request.getQueryString() = " + request.getQueryString());
		System.out.println("request.isSecure() = " + request.isSecure());
		
		System.out.println("--- REQUEST-LINE - END ---");
		System.out.println();
	}
	
	
}
