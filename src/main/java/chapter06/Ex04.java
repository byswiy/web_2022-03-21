package chapter06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


// 세션을 이용해서 urlPatterns를 다양히게 만드는 방법
@WebServlet(name = "ch06_Ex04", urlPatterns = { "/chapter06/session/create" })
public class Ex04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션은 쿠키와 달리 따로 생성하는 코드가 없고
		// 요청 정보를 갖고 있는 객체.getSesstion() 메서드를 호출해서
		// 세션이 없는 클라이언트는 세션이 만들어지고
		// 세션이 있는 클라이언트는 세션ID를 사용해서 기존에 만들어진 세션을 가져옴
		HttpSession session = request.getSession();
		
		// 세션은 null 상태가 될 수 없기 때문에 26번 코드는 사용할 수 없는 코드이다
		if(session == null) {
			System.out.println("세션 없음");
		} else {
			System.out.println("세션 있음");
			
			// 세션이 있다면 방금 만들어진건지 원래 있는건지 판단하는 코드
			if(session.isNew()) {
				System.out.println("세션이 새로 만들어짐");
				
				// 세션은 유지 시간을 정해주지 않으면 기본 1,800초(30분)이 저장된다
//				session.setMaxInactiveInterval(86400);
			} else {
				System.out.println("기존에 만들어진 세션");
			}
			
			// if문 밖으로 빼면 세션을 시작할 때마다 새로운 세션이 만들어지고 3초 내로 접속하지 않으면 사라지게 된다
			// 3초 내 접속하면 기존에 만들어진 세션이라는 코드가
			// 3초 내로 접속하지 못했다면 세션이 새로 만들어짐 이라는 코드가 실행된다
			session.setMaxInactiveInterval(3);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
