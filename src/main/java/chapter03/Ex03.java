package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch03_Ex03", urlPatterns = { "/ch03_ex03" })
public class Ex03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex03() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpServletResponse 응답정보 안에 상태코드를 넣어준다
		response.setStatus(301);
		response.setHeader("Location", "http://localhost/ch03_Ex02");
		
		
		response.setContentType("text/plain;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.append("ex03으로 접근했습니다");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
