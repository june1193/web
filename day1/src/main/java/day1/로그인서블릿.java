package day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class 로그인서블릿 extends HttpServlet {
	
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out  = resp.getWriter();
		out.println("<!DOCTYPE html> ");
		out.println("<html lang=\"en\"> ");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Document</title>");
		out.println("<style>");	 
	    out.println("        .wrap{ ");
		out.println("       width: 400px; ");
		out.println("  padding: 20px;  ");
		out.println(" border: 1px solid black; ");   
		out.println(" margin: 0  auto; ");        
		out.println(" } ");
		out.println("        .img_wrap{ ");
		out.println("            width: 200px ;  ");
		out.println("            height: 200px;  ");
		out.println("            border:1px solid black;  ");
		out.println("            margin: 0 auto; ");
		          
		out.println("	            background-image: url(https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA3MTBfMTM1%2FMDAxNTk0MzU2OTU3NDE1.kwHVEQ7goqvGgtT13CykplFqFHdatF3Px7Jc6hJV4jIg.wPKKyErswASi4HZ5FkuJkDneCyvGBLJLtxAHc3-bvHsg.PNG.daeguart3%2Fcafe-151346_1280.png&type=a340); ");
		out.println("   background-size: cover; ");
		out.println(" background-position: center; ");
        out.println(" }");

		out.println(" .info_wrap{");
		out.println("  width: 300px; ");
		out.println(" padding: 20px; ");
		out.println(" border: 1px solid black;   ");        
 	 	out.println("  margin: 0 auto; ");
        out.println("   margin-top: 20px; ");
	 	out.println("}");

	 	out.println(" input{ ");
	 	out.println(" width: 97%; ");
	    out.println("	     height: 30px; ");
	    out.println("            margin-top: 5px; ");
		out.println("         } ");
		out.println("         button{");
		out.println("            width: 100%;");
		out.println("            margin-top: 10px;");
		out.println("           height: 40px;");
		out.println("            border:0px;");
	    out.println("            border-radius: 5px;");
	    out.println("            background-color: #e1a4a4;");
		            
	    out.println("         }");

	    out.println("    </style>");
	    out.println("</head>");
	    out.println("<body>");

	    out.println("    <h2> 공간태그 : div </h2>");
 	   
	    out.println(" <div class=\"wrap\">");
		       
	    out.println("        <div class=\"img_wrap\">   ");          
	    out.println(" </div>");
		        
	    out.println("        <div class=\"info_wrap\">");
	    out.println("            <input type=\"text\">");
	    out.println("            <input type=\"text\">");
	    out.println("<button>로그인</button>");
	    out.println(" </div>");
	    out.println("</div>");
		    
	    out.println("</body>");
	    out.println("</html> ");
		
	}

}
