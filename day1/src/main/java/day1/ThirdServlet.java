package day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("~~~~~");
		out.close();
	}
	
	

}
