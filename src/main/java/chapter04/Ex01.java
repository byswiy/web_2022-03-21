package chapter04;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch04_Ex01", urlPatterns = { "/ch04_ex01" })
public class Ex01 extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		String[] hobbys = request.getParameterValues("hobby");
		
		String gender = request.getParameter("gender");
		String religion = request.getParameter("rligion");
		String intro = request.getParameter("intro");
		
		System.out.println("POST 파라미터 출력");
		System.out.println("id = " + id);
		
		// 취미를 arrays.toString을 사용하지 않고 hobby에 처음부터 끝까지 접근하는 반복문 사용
		try {
			for(int i=0; i<hobbys.length; i++) {
				System.out.print(hobbys[i] + " ");
			}
		} catch(NullPointerException e) {
			System.out.println("전달된 취미가 없습니다");
		}
//		System.out.println("hobbys = " + Arrays.toString(hobbys));
		System.out.println("gender = " + gender);
		System.out.println("intro = " + intro);
	}

}
