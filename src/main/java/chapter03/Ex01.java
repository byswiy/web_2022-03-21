package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex01
 */
@WebServlet(name = "ch03_Ex01", urlPatterns = { "/chapter03/ex01" })
public class Ex01 extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("MIME TYPE;charset=UTF-8");  
		response.setContentType("text/html;charset=UTF-8");
		
		// �����Ͱ� respones�� ���� ������ setContentType�� ����ؼ� �� �� �ִ�
		PrintWriter outputStream = response.getWriter();
		
		outputStream.append("<html>");
		outputStream.append("	<head>");
		outputStream.append("		<title>Servlet Response Web Page</title>");
		outputStream.append("	</head>");
		outputStream.append("	<body>");
		outputStream.append("		<h1>Nice to meet you!</h1>");
		outputStream.append("       <h1>������ �ݰ����ϴ�!</h1>");
		outputStream.append("	</body>");
		outputStream.append("</html>");
		
		// 전달하려했던 데이터를 다 전달했다는 의미이기도하고 stream에서는 꼭 사용하고 나서 닫아줘야한다
		outputStream.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
