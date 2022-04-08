package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// forward 메서드를 사용하는 메서드
@WebServlet(name = "ch06_Ex11", urlPatterns = { "/ch06_ex11" })
public class Ex11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 따로 forward 해주지 않아도 ex10에서 출력했던 코드만 복사한다
		// sendReDirect와 달리 실행하면 URL은 그대로지만 안의 내용은 forward된 서블릿이 동작하게 된다
		PrintWriter output = response.getWriter();
		
		// request에 저장된 데이터를 꺼낼 때 사용
		String name = request.getParameter("name");
		// setAttribute로 저장한 데이터를 꺼내는 방법
		String name1 = (String) request.getAttribute("name1");
		
		output.print("! ch06_ex11 Servlet !");
		output.print("<h1>name = " + name + "</h1>");
		output.print("<h1>name1 = " + name1 + "</h1>");
		
		output.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
