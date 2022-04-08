package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 사용자의 IP를 사용해서 우리 서비스를 이용한 횟수를 세주는 서블릿
@WebServlet(name = "ch06_Counter", urlPatterns = { "/ch06_counter" })
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			// try catch를 사용해서 예외를 처리하는 방법
			String clientIP = request.getRemoteAddr();
			
			ServletContext context = getServletContext();
			
			int count = 0;
			
			try {
				count = (int) context.getAttribute(clientIP);
			
				
			} catch(NullPointerException e) {

			}
			
			count++;
			
			context.setAttribute(clientIP, count);
			// 위의 4개의 코드들은 이용 횟수를 세서 저장해주는 코드들이다
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter output = response.getWriter();
			
			output.print("<h1>아이피 : " + clientIP + "</h1>");
			output.print("<h1>이용 횟수 : " + count + "</h1>");
			
			output.close();
			
		
			// 예외처리를 Integer를 사용해서 예외를 처리하는 방법
//			String clientIP = request.getRemoteAddr();
//			
//			ServletContext context = getServletContext();
//			
			// getAttribute에 값이 없다면 null을 반환하는데 int에 저장하려고 했기 때문에
			
//			int count = (Integer) context.getAttribute(clientIP);
//			
//			count++;
//			
//			context.setAttribute(clientIP, count);
//			// 위의 4개의 코드들은 이용 횟수를 세서 저장해주는 코드들이다
//			
//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter output = response.getWriter();
//			
//			output.print("<h1>아이피 : " + clientIP + "</h1>");
//			output.print("<h1>이용 횟수 : " + count + "</h1>");
//			
//			output.close();

			
		}
		


}
