package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch06_Ex10", urlPatterns = { "/ch06_ex10" })
public class Ex10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = response.getWriter();
		
		output.print("! ch06_ex10 Servlet !");
		
		// forward를 사용하려면 close전에(응답이 나가기 전에) 사용해야함
		// forward를 하거나 include를 할 때 getRequestDidspatcher를 사용하기 때문에
		// forward할 서블릿의 URI를 인자로 넣어준다
		RequestDispatcher rd = request.getRequestDispatcher("ch06_ex11");
		
		request.setAttribute("name1", "value1");
		
		// 인자로 클라이언트가 요청한 정보, 응답정보를 가진 객체를 넣어준다
		// request 안에 인자로 넣은 uri가 들어있다
		rd.forward(request, response);
		
		output.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
