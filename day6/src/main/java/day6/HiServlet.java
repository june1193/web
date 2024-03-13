package day6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class HiServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		String msg ="hi Servlet";
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<h2>"+msg+"<h2>");
		out.println("<body>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
