package hello.servlet.web.frontcontrller.v5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.web.frontcontrller.ModelView;

public interface MyHandlerAdapter 
{
	boolean supports(Object handler);
	
	ModelView handle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws ServletException, IOException;
}
