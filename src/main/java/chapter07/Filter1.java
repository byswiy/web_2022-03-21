package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.xml.ws.Response;

// implements를 상속하면 add를 해서 필요한 것들을 추가한다
public class Filter1 implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// request(arg0)가 관여
//		System.out.println("<< doFilter() 호출 전 >>");
		System.out.println("Filter1 동작");
		
		// 필터에서 동작하고 있기 때문에 servlet에서의 동작은 불필요한 동작이기 때문에 삭제한다
		arg1.setContentType("text/html;charset=UTF-8");
		
		PrintWriter output = arg1.getWriter();
		
		output.print("<html>");
		output.print("<head>");
		output.print("<title>servlet</title>");
		output.print("</head>");
		output.print("<body>");
		
		// 세 번째 매개 변수 사용
		// 밑의 코드 설명 : 이 필터 다음에 있는 필터 또는 서블릿이 동작한다
		// 필터가 있는 경우 다음 서블릿이나 필터가 동작하고 다시 돌아와서 필터의 밑으로 동작이 실행된다	
		arg2.doFilter(arg0, arg1);
		
		output.print("</body>");
		output.print("</html>");
		
		// 서블릿에 close()를 붙이게 되면 보낼 데이터가 끝났다는 건데 doFilter 이후에 보낼 데이터가 있기 때문에
		// 서블릿에서의 close()는 불필요하기 때문에 삭제한다
		output.close();
		
		
		
		// response(arg1)가 관여
//		System.out.println("<< doFilter() 호출 후 >>");
		
	}
	
}
