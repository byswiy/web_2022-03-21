package chapter06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 쿠키를 꺼내 쓰는 서블릿
@WebServlet(name = "ch06_Ex02", urlPatterns = { "/ch06_ex02" })
public class Ex02 extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		
		// 쿠키를 가지고 있지 않은 클라이언트가 발생하는 예외를 처리해주는 코드
		try {
			for(Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				
				// name이 id인 쿠키를 찾을 때 사용하는 코드
				if(name.equals("id")) {
					System.out.println("이 서비스가 원하는 쿠키가 있음");
				}
				
				System.out.println(name + " = " + value);
			}
			
		} catch(NullPointerException e) {
			System.out.println("쿠키가 없습니다");
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
