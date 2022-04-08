package chapter06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ch06_Ex06", urlPatterns = { "/chapter06/session/add" })
public class Ex06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// 세션에 클라이언트의 IP를 저장해보기
		String clientIP = request.getRemoteAddr();
		
		// Object 모양의 clientIP가 저장된 것
		session.setAttribute("clientIP", clientIP);
		
		
		// 세션에 저장된
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
