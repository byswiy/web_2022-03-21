package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// loginStep3 - 비밀번호 확인 및 로그인 처리 서블릿
// step2에서 검색한 사용자의 비밀번호와
// 로그인 화면에서 사용자가 입력한 비밀번호를 대조해서
// 같아면 로그인 성공 처리, 다르다면 로그인 실패 처리
@WebServlet("/chapter06/login/step3")
public class LoginStep3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String step2Pass = (String) request.getAttribute("step2");
		
		if(step2Pass == null) {
			// step1을 통과하지 않고 직접 URL을 입력해서 step2로 넘어 온 경우
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter output = response.getWriter();
			
			output.print("<h1>접근권한이 없습니다.</h1>");
			
			output.close();
			
			// return을 만나 메서드가 끝이난다
			return;
		} 
		
		
		String pw = request.getParameter("pw");
		
		MemberInfo memberInfo = (MemberInfo) request.getAttribute("memberInfo");
		String memberPW = memberInfo.getPw();
		
		// id로 조회한 사용자의 pw와 -> String memberPW 부분
		// 사용자가 입력한 pw를 대조 해야한다 -> String pw부분
		boolean isSame = memberPW.equals(pw);

		
		// 대조 했을 때 일치한다면 로그인 성공 처리
		// 로그인 성공 처리(세션에 isLogin의 값을 true로 기록)
		if(isSame) {
			HttpSession session = request.getSession();
			
			session.setAttribute("isLogin", true);
			
			response.sendRedirect("/member/login/loginSuccess.html");
		} else {
			// 대조 했을 때 일치하지 않는다면 로그인 실패 처리
			// 비밀번호를 확인하세요 등의 문구 출력
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter output = response.getWriter();
			
			output.print("<h1>비밀번호가 일치하지 않습니다.</h1>");
			
			output.close();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
