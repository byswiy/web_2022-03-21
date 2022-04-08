package jquery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "jquery_Second", urlPatterns = { "/jquery/second" })
public class Second extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 두 번째 컨텐츠를 DB에서 불러옴
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		// 불러온 두 번째 데이터를 클라이언트에게 전달
		
//		response.setStatus(500);
		response.setContentType("text/plain;charset=UTF-8");
		
		PrintWriter output = response.getWriter();
		
		output.print("두 번째 컨텐츠");
		
		output.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
