package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch03_Ex02", urlPatterns = { "/ch03_ex02" })
public class Ex02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex02() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 현재 페이지에 없기 때문에 다른 파일로 넘어가도록 하는 메서드
		response.sendRedirect("/ch03_ex02.html");
		
//		PrintWriter output = response.getWriter();
//		output.append("<html>");
//		output.append("<head>");
//		output.append("<title>ch03_ex02 페이지</title>");
//		output.append("<style>");
//		output.append(" div {width: 50px; height: 50px; display: inline-block;");
//		output.append(".red {background-color: red;");
//		output.append(".orange {background-color: orange;");
//		output.append(".yellow {background-color: yellow;");
//		output.append(".green {background-color: green;");
//		output.append(".blue {background-color: blue;");
//		output.append(".navy {background-color: navy;");
//		output.append(".purple {background-color: purple;");
//		output.append("</style>");
//		output.append("</head>");
//		output.append("<body>");
//		output.append("<div class="red"></div>");
//		output.append("<div class="orange"></div>");
//		output.append("<div class="yellow"></div>");
//		output.append("<div class="green"></div>");
//		output.append("<div class="blue"></div>");
//		output.append("<div class="navy"></div>");
//		output.append("<div class="purple"></div>");
//		output.append("</body>");
//		output.append("</html>");

			

			

			
			
			
			
			
			
			
			

		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
