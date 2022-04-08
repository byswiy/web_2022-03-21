package chapter03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch03_Join", urlPatterns = { "/ch03_join" })  // URL에는 왠만하면 대문자를 안쓰는 게 좋다
public class Join extends HttpServlet {
	// 회원 정보를 저장할 class를 만들어야함
	// DB역할을 하는 객체는 서버를 생성할 때 생기고 서버를 내리면 사라진다
	public static List<MemberInfo> memberInfoList = new ArrayList<>();
	
	public boolean checkParameter(String id, String pw, HttpServletResponse response) throws IOException{
		// parameter가 올바른지의 여부
		boolean pass = true;
		// 아이디나 비밀번호를 입력하지 않았을 경우
				if(id.length() == 0 || pw.length() == 0) {
					response.sendRedirect("/joinFail.html");
				
				// 아이디나 비밀번호에 공백이 포함되었을 경우
				// 공백이 있다면 공백의 인덱스 번호를 알려주는 것
				} else if(id.indexOf(' ') != -1 || pw.indexOf(' ') != -1) {
					response.sendRedirect("/joinFail.html");
					pass = false;
					
				// id와 pw 길이를 제한하는 경우
				} else if(id.length() < 4 || id.length() > 10) {
					response.sendRedirect("/joinFail.html");
					pass = false;
					
				} else if(pw.length() < 6 || pw.length() > 16) {
					response.sendRedirect("/joinFail.html");
					pass = false;
				// 아이디와 비빌번호에 정하지 않은 특수문자가 들어있을 경우
				}
				
				return pass;
	}
	
	public boolean usedId(String id) {
		boolean exist = false;
		for(MemberInfo nthMemberInfo : memberInfoList) {
			String nthID = nthMemberInfo.getId();
			
			if(nthID.equals(id)) {
				exist = true;
				break;
			}	
		}
		return exist;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 전달한 id와 pw 값을 꺼낸다.
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(id);
		System.out.println(id.length());
		
		// parameter가 올바른지 여부를 확인 (checkParameter) 할 때
		// 올바르지 않다면 클라이언트가 리다이렉트 해야할 경로를 지정해줬으므로
		// 올바르지 않을 때는 리다이렉트 해야할 경로로 이동하로독 이 서블릿이 그대로 끝날 수 있게 if문 구성
		boolean pass = checkParameter(id, pw, response);
		
		if(!pass) {
			return;
		}
		
		// 회원가입 : 새로운 회원의 정보를 이 사이트의 데이터베이스에 저장하는 것
		// DB 역할을 할 List 사용 -> doPost안에 만드는 것이 아닌 밖에 만들어야한다
		MemberInfo memberInfo = new MemberInfo(id, pw);
		
		// id 중복 여부 체크
		// 1. memberInfoList의 처음부터 끝까지 접근
		// 2. n번째 회원 정보를 꺼냄
		// 3. n 번째 회원 정보에서 ID를 꺼냄
		// 4. 꺼낸 ID와 사용자가 입력한 아이디가 같다면 아이디 중복이라고 표시
		// 5. 꺼낸 ID와 사용자가 입력한 아이디가 같지않다면 아이디 중복 아님이라고 표시
		
		
		// 아이디 중복여부 체크
		boolean exist = usedId(id);
		
		// 아이디가 사용중이라면 
		//회원 가입 실패 페이지로 이동
		if(exist) {
			response.sendRedirect("/joinFail.html");
		} else {
		// 아이디가 사용중이지 않으면
		// 회원가입
		memberInfoList.add(memberInfo);
		
		// 서블릿에서 sendRedirect URI부분만 입력한다
		// html에서 입력할 때는 URL을 입력한다
		
		// 회원가입 완료 페이지로 이동
		response.sendRedirect("/joinSuccess.html");
		}
	
	}
}
