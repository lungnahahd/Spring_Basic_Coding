package hello.servlet.web.servlletmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String viewPath = "/WEB-INF/views/new-form.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath); // 해당 경로로 이동한다는 의미 
		dispatcher.forward(req, resp); // 실제 JSP로 이동하는 코드 
	}
}
