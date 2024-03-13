package day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RSP")
public class 가위바위보 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // 사용자가 입력한 값 받기
        String userHand = request.getParameter("myHand");
        
        // 랜덤 값 생성 (1: 가위, 2: 바위, 3: 보)
        Random random = new Random();
        int serverHand = random.nextInt(3) + 1;
        
        // 서버의 선택에 따른 문자열
        String serverHandStr = "";
        switch(serverHand) {
            case 1:
            	serverHandStr = "가위";
                break;
            case 2:
            	serverHandStr = "바위";
                break;
            case 3:
            	serverHandStr = "보";
                break;
        }
        
        // 결과 계산
        String result = "";
        if(userHand.equals(serverHandStr)) {
            result = "비겼습니다.";
        } else if((userHand.equals("가위") && serverHandStr.equals("보"))
                || (userHand.equals("바위") && serverHandStr.equals("가위"))
                || (userHand.equals("보") && serverHandStr.equals("바위"))) {
            result = "사용자 승!";
        } else {
            result = "서버 승!";
        }
        
        // 결과 출력 및 CSS 적용
        out.println("<html><head>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #FFFF99; text-align: center; }");
        out.println("h1 { color: blue; }");
        out.println("p { font-size: 18px; }");
        out.println(".result { font-size: 24px; font-weight: bold; }"); // 추가: 결과 텍스트 스타일 지정
        out.println("</style>");
        out.println("</head><body>");
        out.println("<h1>가위바위보 대결</h1>");
        out.println("<p>사용자의 선택: " + userHand + "</p>");
        out.println("<p>서버의 선택: " + serverHandStr + "</p>");
        out.println("<p class=\"result\">결과: " + result + "</p>"); // 수정: 결과 텍스트에 클래스 적용
        out.println("</body></html>");
    }
}