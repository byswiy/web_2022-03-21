package chapter03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch03_Ex05", urlPatterns = { "/ch03_ex05" })
public class Ex05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex05() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인자로 문자열로 된 name을 주면 그 값을 value로 받는다
		// get 방식으로 전달하면 경로?name1=value1 & name2=value2
		// URL => http://192.168.10.4/ch03_Ex05?id= &pw=
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 로그인 : 회원정보 중에서 사용자가 입혁한 id와 pw가 일치하는 회원정보를 select하는 것
		// 회원 정보 DB의 처음부터 끝까지 접근해서
		// n번째 회원의 아이디와 비밀번호가 사용자가 입력한 아이디와 비밀번호와 일치한다면
		// 로그인 성공
		// 그렇지 않다면
		// 로그인 실패
		
		// 가정을 두고 코드를 만들면 더 쉽게 만들 수 있다 -> true로 하면 실패 할 경우의 수가 많기 때문에 코드가 길어진다
		//								   	   -> false로 하면 성공할 한 번의 경우의 수를 사용하면 된다
		
		MemberInfo memberInfo = new MemberInfo(id, pw);
		
		boolean success = false;
		for(MemberInfo nthMemberList : Join.memberInfoList) {
			
			if(memberInfo.equals(nthMemberList)) {   // nthMemberList.getId().equals(id) && nthMemberList.getPw().equals(pw)
				// 로그인 성공
				success = true;
				break;
			} 
		}
		
		if(success) {
			response.sendRedirect("loginSuccess.html");
		} else {
			response.sendRedirect("loginFail.html");
		}
		
//		System.out.println("클라이언트가 전달한 id값 => " + id);
//		System.out.println("클라이언트가 전달한 pw값 => " + pw);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
