package mystudy;
//서블릿 파일
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/study")
public class AcornOneServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        
        // Service 객체 생성
        AcornService service = new AcornService();
        
        // DAO를 통해 데이터 조회
        Acorn acorn = service.getMember(id);
        
        // 조회된 데이터를 request 저장소로 가져옴
        request.setAttribute("acorn", acorn);
        
        // 뷰 JSP파일로 forward
        request.getRequestDispatcher("/member.jsp").forward(request, response);
    }
}