package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// [status-line]
		resp.setStatus(HttpServletResponse.SC_OK); // 200 응답을 response 
		
		// [response-headers]
		resp.setHeader("Content-Type", "text/plain");
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("my-header", "hello");
		
		cookie(resp);
		redirect(resp);
		
		// [response-headers]
		PrintWriter writer = resp.getWriter();
		writer.println("OK");
	}
	
	// Cookie 지원
	// 아래와 같이 서버에서 응답으로 보내면, 다음 요청때분터 해당 헤더를 포함해서 서버에 클라이언트가 요청! 
	private void cookie(HttpServletResponse response)
	{
		// 아래 주석처럼 사용도 가능한데, 번거롭게 형식도 맞춰주고 해야되므로 이렇게 제공해주는 객체 이용 
		//response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
		Cookie cookie = new Cookie("mycookie", "good");
		cookie.setMaxAge(600); // 600초
		response.addCookie(cookie);
		
	}
	
	private void redirect(HttpServletResponse response) throws IOException
	{
		// 아래 두 코드가 번거로운 것을 한줄의 코드로 대체 가능 !
		//response.setStatus(HttpServletResponse.SC_FOUND);
		//response.setHeader("Location", "/basic/hello-form.html");
		response.sendRedirect("/basic/hello-form.html");
	}
}
