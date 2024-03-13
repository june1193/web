package day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿 작성
//서블릿 동작

//서블릿 작성(서블릿: 사용자 요청에 대한 응답정보를 동적으로 만들어 주는 기술)
//1. 서블릿을 상속한다. HttpServlet
//2. service() 매서드를 오버라이드 한다
//3. 응답내용을 작성

@WebServlet("/hi.do")
public class FirstServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		out.println("hello servlet");
		
		System.out.println("hello servlet");
	}

	
	
}
