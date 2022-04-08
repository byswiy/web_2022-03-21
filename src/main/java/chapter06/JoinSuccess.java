package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 정말 회원가입을 완료했는지 판단하는 서블릿
@WebServlet(name = "ch06_JoinSuccess", urlPatterns = { "/servlet/member/joinSuccess" })
public class JoinSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		
		try {
			for(Cookie cookie : cookies) {
			String name = cookie.getName();
			
			if(name.equals("isJoin")) {
				String value = cookie.getValue();
				
				if(value.equals("true")) {
					response.setContentType("text/html;charset=UTF-8");
					
					PrintWriter output = response.getWriter();
					
					// html로 이동하는 것이 아닌 서블릿에서 직접 보여주는 것
					output.print("<h1>회원 가입 완료</h1>");
					output.print("<a href=\"/main/index.html\">메인 페이지로 이동</a>");
					
					output.close();
					
//					response.sendRedirect("/member/join/joinSuccess.html");
				}
			}
		}
	} catch(NullPointerException e) {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter output = response.getWriter();
		
		output.print("<h1>접근권한이 없습니다</h1>");
		output.print("<a href=\"/member/join/join.html\">회원가입 페이지로 이동</a>");
		
		output.close();
	}
		}
		
		
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
