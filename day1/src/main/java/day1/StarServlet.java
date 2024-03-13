package day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/stars")
public class StarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        // 사용자가 요청한 별의 수를 파라미터로부터 가져옵니다.
        String starCountParam = request.getParameter("count");
        
        // 파라미터가 없거나 비어있는 경우 기본값으로 5를 사용합니다.
        int starCount = 0;
        if (starCountParam != null && !starCountParam.isEmpty()) {
            try {
                starCount = Integer.parseInt(starCountParam);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        
        // HTML 응답을 생성합니다.
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Star Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>별 출력 서비스</h1>");
        out.println("<p>원하는 수만큼의 별을 출력합니다.</p>");
        out.println("<p>별의 개수: " + starCount + "</p>");
        out.println("<p>별:</p>");
        
        // 사용자가 요청한 수만큼의 별을 출력합니다.
        for (int i = 0; i < starCount; i++) {
            out.println("* ");
        }
        
        out.println("</body>");
        out.println("</html>");
    }
}
