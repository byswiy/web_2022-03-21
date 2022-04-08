package chapter01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second") // 원래는 이렇게 사용해야한다 -> urlPatterns = "/second", name = "second"
public class Ex03 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Ex03 서블릿 호출");
	}

	
//	@Override
//	public void doGet(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		System.out.println("Ex03 서블릿 호출");
//		
//	}

	
	
}
