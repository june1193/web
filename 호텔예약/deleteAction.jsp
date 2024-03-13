<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 정보 삭제 결과</title>
</head>
<body>

<%
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:testdb";
    String user = "scott";
    String password = "tiger";
    
    Connection con = null;
    PreparedStatement pstDelete = null;
    
    try {
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, password);
        
        // 사용자가 선택한 예약 번호 받아오기
        String reservation_id = request.getParameter("reservation_id");
        
        // 해당 예약 정보 삭제
        pstDelete = con.prepareStatement("DELETE FROM reservation WHERE reservation_id = ?");
        pstDelete.setString(1, reservation_id);
        
        int rowsAffected = pstDelete.executeUpdate();
        
        if (rowsAffected > 0) {
%>
<h2>예약 정보 삭제 성공</h2>
<p>선택하신 예약 정보가 성공적으로 삭제되었습니다.</p>
<a href="main.html">홈으로 돌아가기</a>
<%
        } else {
%>
<h2>예약 정보 삭제 실패</h2>
<p>선택하신 예약 정보를 삭제하는 중 문제가 발생했습니다.</p>
<%
        }
    } catch (Exception e) {
        out.println("오류 발생: " + e.getMessage());
    } finally {
        if (pstDelete != null) pstDelete.close();
        if (con != null) con.close();
    }
%>

</body>
</html>