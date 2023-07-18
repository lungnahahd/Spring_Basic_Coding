package hello.servlet.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StreamUtils;

@SuppressWarnings("serial")
@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		ServletInputStream inputStream = req.getInputStream(); // 바이트 코드를 있는대로 가져오기 
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // 가져온 바이트 코드를 String으로 변환 (Spring 제공) 
		
		System.out.println("messageBody = " + messageBody);
	}
}
