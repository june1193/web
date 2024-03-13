package day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sachick")
public class 사칙연산 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String su1 = request.getParameter("su1");
		String su2 = request.getParameter("su2");
			
		out.println();
	}

}
