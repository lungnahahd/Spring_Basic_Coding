package hello.servlet.web.frontcontrller.v5.adapter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.web.frontcontrller.ModelView;
import hello.servlet.web.frontcontrller.v5.MyHandlerAdapter;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter
{

	@Override
	public boolean supports(Object handler) 
	{
		// return (handler instanceof ControllerV3);
		return true;
	}

	@Override
	public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object Handler)
			throws ServletException, IOException 
	{
		// ControllerV3 controller = (ControllerV3) handler;
		
		// ModleView mv = controller.process();
		// return mv;
		
		return null;
	}


}
