package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// loginStep1 - 파라미터 확인 로그인 
// 로그인을 하기 위해 필요한 파라미터를 전달했는지 확인하는 서블릿
@WebServlet("/chapter06/login/step1")
public class LoginStep1 extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if((id == null || pw == null) ||(id.length() == 0 || pw.length() == 0)) {
			// 로그인에 필요한 파라미터 중 하나 이상을 전달받지 못했다
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter output = response.getWriter();
			
			// 아이디와 비밀번호를 입력하라고 알려주는 코드
			output.print("<h1>아이디 또는 비밀번호를 입력하세요</h1>");
			
			output.close();
		} else {
			request.setAttribute("step1", "pass");
			// 아이디와 비밀번호를 전달받았을 때 다음 서블릿으로 넘어가는 코드
			RequestDispatcher rd = request.getRequestDispatcher("/chapter06/login/step2");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
