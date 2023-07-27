package hello.servlet.web.servlletmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.basic.domain.member.Member;
import hello.servlet.basic.domain.member.MemberRepository;

@SuppressWarnings("serial")
@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet  extends HttpServlet
{
	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String username = req.getParameter("username");
		int age = Integer.parseInt(req.getParameter("age")); // http 요청은 무조건 문자열로 받기에 변환 필요!
		
		Member member = new Member(username, age);
		memberRepository.save(member);
		
		// 이전과는 다르게 Model에 데이터를 보관
		// 여기서는 간략하게 request에서 데이터를 임시 보관할 수 있는 기능을 사용 
		req.setAttribute("member", member);
		
		String viewPath = "/WEB-INF/views/save-result.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
		
	}
}
