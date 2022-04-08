package chapter06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch06_Ex01", urlPatterns = { "/ch06_ex01" })
public class Ex01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿠키를 생성할 때는 생성자 사용
		// id라는 name에 guest 저장하는 코드
		Cookie c1 = new Cookie("id", "guest");
		
		// 초 단위로 입력하고 쿠키를 가지는 유지시간을 정할 수 있다 -> 한 시간은 60 * 60을 하면 된다
		// expire을 해주지 않으면 브라우저를 닫기 전까지 가지고 있다가 브라우저가 닫히면 버리게 된다
		c1.setMaxAge(60 * 60 * 3);
	
		
		// 클라이언트의 상태정보를 클라이언트로 보내는 코드
		response.addCookie(c1);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
