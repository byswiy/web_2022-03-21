package chapter06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// loginStep2 - 회원정보 조회 서블릿
// 사용자가 입력한 아이디로 회원 정보를 조회함
@WebServlet("/chapter06/login/step2")
public class LoginStep2 extends HttpServlet {
	// DB 역할을 할 임시 회원정보
	public static List<MemberInfo> database;
	
	// context나 initparameter을 사용할 게 아니라서 인자 없는 걸로 오버라이딩
	@Override
	public void init() throws ServletException {
		database = new ArrayList<>();
		
		// 로그인 부분을 건너뛰기 위해 회원 가입 역할을 하는 코드
		MemberInfo memberInfo = new MemberInfo("id1", "pw1", "name1");
		
		database.add(memberInfo);
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String step1pass = (String) request.getAttribute("step1");
		
		if(step1pass == null) {
			// step1을 통과하지 않고 직접 URL을 입력해서 step2로 넘어 온 경우
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter output = response.getWriter();
			
			output.print("<h1>접근권한이 없습니다.</h1>");
			
			output.close();
			
			// return을 만나 메서드가 끝이난다
			return;
		} 
		
		// DB르르 사용해서 회우너 정보 조회
		String id = request.getParameter("id");
		
		MemberInfo memberInfo = null;
		for(MemberInfo nthMemberInfo : database) {
			String nthMemberId = nthMemberInfo.getId();
			
			if(nthMemberId.equals(id)) {
				memberInfo = nthMemberInfo;
			}
		}
		
		if(memberInfo == null) {
			// 사용자가 입력한 아이디와 일치하는 회원 정보 없음
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter output = response.getWriter();
			
			output.print("<h1>일치하는 아이디가 없습니다.</h1>");
			
			output.close();
		} else {
			request.setAttribute("step2", "pass");
			// step3에서 아이디가 일치한 회원 정보를 저장하기 위해
			request.setAttribute("memberInfo", memberInfo);
			
			// step3으로 이동해 비밀번호 대조 및 로그인 처리
			RequestDispatcher rd = request.getRequestDispatcher("/chapter06/login/step3");
			rd.forward(request, response);
		}
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
