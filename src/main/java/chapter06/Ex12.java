package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// include 메서드를 사용해보는 서블릿
@WebServlet(name = "ch06_Ex12", urlPatterns = { "/ch06_ex12" })
public class Ex12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter output = response.getWriter();
		
		output.print("! ch06_ex12 Servlet !");
		
		request.setAttribute("name1", "value1");
		
		RequestDispatcher rd = request.getRequestDispatcher("ch06_ex11");
		rd.include(request, response);
		
		output.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
