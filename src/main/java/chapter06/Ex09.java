package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch06_Ex09", urlPatterns = { "/ch06_ex09" })
public class Ex09 extends HttpServlet {
	private ServletContext context;
       
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		context = config.getServletContext();
//	}
	
	// serveltContext 사용
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		// 데이터를 우회적으로 저장하는 방법 -> web.xml에 저장해두고 getInitParameter를 사용해 꺼내 쓸 수 있음
		// 문자열 방식으로 값을 꺼낸다
		String shutDownTime = context.getInitParameter("shutDownTime");
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter output = response.getWriter();
		
		output.print("<h1>Chapter06 - Ex09 입니다</h1>");
		output.print("<p>서버가 " + shutDownTime + "에 임시 점검을 시작합니다.</p>");
		output.print("<p>임시 점검을 시작하기 전 작업을 마무리 하세요.</p>");
		
		// 인자로 지정한 경로의 파일이 실제 프로젝트 내에서는 어디에 위치하는 지 알려주는 메서드
		String realPath = context.getRealPath("index.html");
		System.out.println(realPath);
		
		output.close();
		
//		System.out.println(context);
		
	}
}
