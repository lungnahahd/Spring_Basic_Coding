package hello.servlet.web.frontcontrller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyView 
{
	private String viewPath;
	
	public MyView (String viewPath)
	{
		this.viewPath = viewPath;
	}
	
	public void render (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// viewPath 경로로 이동하는 것! 
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response); 
	}
}
