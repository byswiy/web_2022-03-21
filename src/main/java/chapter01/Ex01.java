package chapter01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex01")
public class Ex01 extends HttpServlet {
	private static final long serialVersionUID = 1L;   // java에'직렬화'때문에 사용하는 것으로 우리는 사용할 일이 전혀 없기때문에 없어도 된다
       
    public Ex01() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    // service 메서드를 이용해서 요청을 처리할 것인지 doGet, doPost로 나눠서 get을 처리할지 정하는 것
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 기본 영어를 한글로 바꿀 때 사용
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Ex01 서비스를 이용해주셔서 감사합니다!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
