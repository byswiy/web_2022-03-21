package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch03_Ex04", urlPatterns = { "/ch03_ex04" })
public class Ex04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex04() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String scheme = request.getScheme();
		String remoteAddr = request.getRemoteAddr();
		int remotePort = request.getRemotePort();
		
//		System.out.println("클라이언트는 " + scheme + " 프로토몰을 사용해서 이 서블릿으로 접근했고");
//		System.out.println("IP(인터넷 주소)가 " + remoteAddr + " 인 사용자가 이 서블릿에 접근했고");
//		System.out.println("클라이언트의 포트는 " + remotePort + " 입니다.");

		
		PrintWriter out = response.getWriter();
		
		// html은 정적인 컨텐츠만 보여주고 동적인 컨텐츠를 보여줄 수 없기 때문에 (현재 IP주소가 다 다름) 따로 html 페이지를 sendRedirect로 만들어서 사용할 수 없다
		out.append("<html>");
		out.append("	<head>");
		out.append("	</head>");
		out.append("	<body>");
		out.append("		<h3>클라이언트의 네트워크 관련된 요청 정보</h3>");
		out.append("		<p>사용한 프로토콜 :  " + scheme + "</p>");
		out.append("		<p>클라이언트의 IP주소 :  " + remoteAddr + "</p>");
		out.append("		<p>클라이언트의 포트 :  " + remotePort + "</p>");
		out.append("	</body>");
		out.append("</html>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
