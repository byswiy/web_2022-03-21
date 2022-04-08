package jquery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "jquery_Json", urlPatterns = { "/jquery/json" })
public class Json extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setContentType에서 우리가 보낼 데이터가 Json이라는 것을 명시할 수 있다
		response.setContentType("application/json;charset=UTF-8");   // json의 MIME TYPE은 application이다.
		
		// 서블릿이 데이터를 전달할 때
		PrintWriter output = response.getWriter();
		
		// Json은 자바가 아닌 자바스크립트에서 동작하는 것이기 때문에
		// 자바에서 사용하기 위해서는 중괄호를 ""로 묶어준다.
		output.print("{ "
				+ "     \"name\": \"김철수\","
				+ "     \"age\": 27,"
				+ "     \"height\": 179.7,"
				+ "     \"addr\": \"부산광역시\","
				+ "     \"university\": {"
				+ "                      \"name\": \"인천대학교\","
				+ " 	                 \"major\": \"컴퓨터공학과\","
				+ " 	                 \"number\": 200901454,"
				+ " 	                 \"admission\": \"2009년\","
				+ " 	                 \"gradutaion\": \"2016년\""
				+ "     },"
				+ "     \"school_name\": [\"건지초\", \"가좌중\", \"정산고\", \"인천대\"]"
				+ "}");
		
		output.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
