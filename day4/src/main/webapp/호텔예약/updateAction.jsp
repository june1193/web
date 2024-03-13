<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 정보 업데이트 결과</title>
</head>
<body>

<%
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:testdb";
    String user = "scott";
    String password = "tiger";
    
    Connection con = null;
    PreparedStatement pstUpdate = null;
    
    try {
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, password);
        
        // 사용자가 입력한 변경된 예약 정보 받아오기
        String room_id = request.getParameter("room_id");
        int num_of_guest = Integer.parseInt(request.getParameter("num_of_guest"));
        int breakfast = Integer.parseInt(request.getParameter("breakfast"));
        String check_in_date = request.getParameter("check_in_date");
        String check_out_date = request.getParameter("check_out_date");
        
        // 예약번호와 손님번호로 해당 예약 정보 업데이트
        String reservation_id = request.getParameter("reservation_id");
        String customer_id = request.getParameter("customer_id");
        
        System.out.println(room_id + num_of_guest + breakfast + check_in_date + check_out_date + reservation_id + customer_id);
        
        
        
        
        pstUpdate = con.prepareStatement("UPDATE reservation SET room_id=?, num_of_guest=?, breakfast=?, check_in_date=?, check_out_date=? WHERE reservation_id=? AND customer_id=?");
        pstUpdate.setString(1, room_id);
        pstUpdate.setInt(2, num_of_guest);
        pstUpdate.setInt(3, breakfast);
        pstUpdate.setString(4, check_in_date);
        pstUpdate.setString(5, check_out_date);
        pstUpdate.setString(6, reservation_id);
        pstUpdate.setString(7, customer_id);
        
        int rowsAffected = pstUpdate.executeUpdate();
        
        if (rowsAffected > 0) {
%>
<h2>예약 정보 업데이트 성공</h2>
<p>예약 정보가 성공적으로 업데이트되었습니다.</p>
<a href="main.html">홈으로 돌아가기</a>
<%
        } else {
%>
<h2>예약 정보 업데이트 실패</h2>
<p>예약 정보 업데이트 중 문제가 발생했습니다.</p>
<%
        }
    } catch (Exception e) {
        out.println("오류 발생: " + e.getMessage());
    } finally {
        if (pstUpdate != null) pstUpdate.close();
        if (con != null) con.close();
    }
%>

</body>
</html>