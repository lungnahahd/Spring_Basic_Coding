package hello.servlet.basic;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("HelloServlet.service");
		
		String test = request.getParameter("username");  // Servlet 으로 query param 을 편하게 받아오는 것이 가능 
		System.out.println("test = " + test);  
		
		// http 메시지 헤더에 들어가는 정보 기입 
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		
		// http 메시지 body에 들어가는 정보 기입 
		response.getWriter().write("respTest =" + test);
		
	}
}
