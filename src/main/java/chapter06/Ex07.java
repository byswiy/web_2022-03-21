package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ch06_Ex07", urlPatterns = { "/chapter06/session/get" })
public class Ex07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// session에 저장된 clientIP를 꺼내쓰는 세블릿
		// String으로 형변환 해주지 않으면 clientIP는 Object 타입이라서 문자열처럼 보이지만 object 타입이 되어버렸기 때문
		String clientIP = (String) session.getAttribute("clientIP");
		
		response.setContentType("text/html;charset =UTF-8");
		
		PrintWriter output = response.getWriter();
		
		output.print("<h1>당신의 IP는 <span style=\"color: red;\">" + clientIP + "</span> 입니다.</h1>");
		
		// 세션에 들어있는 값을 삭제해보는 코드
		session.removeAttribute("clientIP");
		
		output.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
