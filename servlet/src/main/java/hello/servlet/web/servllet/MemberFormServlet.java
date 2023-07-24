package hello.servlet.web.servllet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.basic.domain.member.MemberRepository;

@SuppressWarnings("serial")
@WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HttpServlet
{
	// 싱글톤으로 구현되어 있기에 new가 아니라 바로 호출만 가능 
	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter w = resp.getWriter();
		w.write("<!DOCTYPE html>\n" +
				"<html>\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <title>Title</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"<form action=\"/servlet/members/save\" method=\"post\">\n" +
				"    username: <input type=\"text\" name=\"username\" />\n" +
				"    age:      <input type=\"text\" name=\"age\" />\n" +
				" <button type=\"submit\">전송</button>\n" + "</form>\n" +
				"</body>\n" +
				"</html>\n");
	}
}
