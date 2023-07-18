package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException
	{
		System.out.println("전체 파라미터 조회");
		req.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println(paramName + " = " + req.getParameter(paramName)));
		System.out.println();
		
		System.out.println("단일 파라미터 조회");
		String username = req.getParameter("username");
		String age = req.getParameter("age");
		
		System.out.println("username = " + username);
		System.out.println("age = " + age);
		System.out.println();
		
		 
		System.out.println("이름이 같은 복수 파라미터 조회");
		String[] usernames = req.getParameterValues("username"); // 복수개를 리스트 형식으로 전달 받아서 사용 가능 
		for (String name : usernames)
		{
			System.out.println("username = " + name);
		}
	}
}
