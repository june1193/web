<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 정보 변경</title>
</head>
<body>

<%
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:testdb";
    String user = "scott";
    String password = "tiger";
    
    Connection con = null;
    PreparedStatement pstSelect = null;
    PreparedStatement pstUpdate = null;
    ResultSet rs = null;
    
    try {
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, password);
        
        // 사용자가 입력한 예약번호와 손님번호로 예약 정보 조회
        String reservation_id = request.getParameter("reservation_id");
        String customer_id = request.getParameter("customer_id");
        
        pstSelect = con.prepareStatement("SELECT * FROM reservation WHERE reservation_id = ? AND customer_id = ?");
        pstSelect.setString(1, reservation_id);
        pstSelect.setString(2, customer_id);
        rs = pstSelect.executeQuery();
        
        System.out.println(reservation_id + customer_id);
        
        // 조회된 예약 정보를 폼에 출력
        if (rs.next()) {
%>
<h2>예약 정보 변경</h2>
<form name="reservationForm" action="updateAction.jsp" method="post" onsubmit="return validateForm()">
    예약번호: <%= rs.getString("reservation_id") %><br>
    손님번호: <%= rs.getString("customer_id") %><br>
    호실: <select name="room_id">
    <% if ("R001".equals(rs.getString("room_id"))) { %>
        <option value="R001" selected>R001</option>
    <% } else { %>
        <option value="R001">R001</option>
    <% } %>
    
    <% if ("R002".equals(rs.getString("room_id"))) { %>
        <option value="R002" selected>R002</option>
    <% } else { %>
        <option value="R002">R002</option>
    <% } %>
    
    <% if ("R003".equals(rs.getString("room_id"))) { %>
        <option value="R003" selected>R003</option>
    <% } else { %>
        <option value="R003">R003</option>
    <% } %>
    
    <% if ("R004".equals(rs.getString("room_id"))) { %>
        <option value="R004" selected>R004</option>
    <% } else { %>
        <option value="R004">R004</option>
    <% } %>
    
    <% if ("R005".equals(rs.getString("room_id"))) { %>
        <option value="R005" selected>R005</option>
    <% } else { %>
        <option value="R005">R005</option>
    <% } %>
    
    <% if ("R006".equals(rs.getString("room_id"))) { %>
        <option value="R006" selected>R006</option>
    <% } else { %>
        <option value="R006">R006</option>
    <% } %>
</select><br>
    입실인원 수: <input type="text" name="num_of_guest" value="<%= rs.getInt("num_of_guest") %>"><br>
    조식여부: 
    <select name="breakfast">
        <option value="1" <% if (rs.getInt("breakfast") == 1) out.print("selected"); %>>조식 포함</option>
        <option value="0" <% if (rs.getInt("breakfast") == 0) out.print("selected"); %>>조식 미포함</option>
    </select><br>
    체크인 날짜: 
   <select name="check_in_date">
    <% 
        for (int i = 1; i <= 31; i++) {
            String day = (i < 10) ? "0" + i : String.valueOf(i);
            String date = "2024-03-" + day;
            String selected = date.equals(rs.getString("check_in_date")) ? "selected" : "";
    %>
    <option value="<%= date %>" <%= selected %>><%= date %></option>
    <% } %>
    <% 
        for (int i = 1; i <= 30; i++) {
            String day = (i < 10) ? "0" + i : String.valueOf(i);
            String date = "2024-04-" + day;
            String selected = date.equals(rs.getString("check_in_date")) ? "selected" : "";
    %>
    <option value="<%= date %>" <%= selected %>><%= date %></option>
    <% } %>
    <% 
        for (int i = 1; i <= 31; i++) {
            String day = (i < 10) ? "0" + i : String.valueOf(i);
            String date = "2024-05-" + day;
            String selected = date.equals(rs.getString("check_in_date")) ? "selected" : "";
    %>
    <option value="<%= date %>" <%= selected %>><%= date %></option>
    <% } %>
</select><br>
    체크아웃 날짜: 
    <select name="check_out_date">
    <% 
        for (int i = 1; i <= 31; i++) {
            String day = (i < 10) ? "0" + i : String.valueOf(i);
            String date = "2024-03-" + day;
            String selected = date.equals(rs.getString("check_out_date")) ? "selected" : "";
    %>
    <option value="<%= date %>" <%= selected %>><%= date %></option>
    <% } %>
    <% 
        for (int i = 1; i <= 30; i++) {
            String day = (i < 10) ? "0" + i : String.valueOf(i);
            String date = "2024-04-" + day;
            String selected = date.equals(rs.getString("check_out_date")) ? "selected" : "";
    %>
    <option value="<%= date %>" <%= selected %>><%= date %></option>
    <% } %>
    <% 
        for (int i = 1; i <= 31; i++) {
            String day = (i < 10) ? "0" + i : String.valueOf(i);
            String date = "2024-05-" + day;
            String selected = date.equals(rs.getString("check_out_date")) ? "selected" : "";
    %>
    <option value="<%= date %>" <%= selected %>><%= date %></option>
    <% } %>
</select><br>
    <input type=hidden name=reservation_id value="<%= rs.getString("reservation_id")%>">
    <input type=hidden name=customer_id value="<%= rs.getString("customer_id")%>">
    <input type="submit" value="변경">
    
</form>

<br>

<form action="deleteAction.jsp" method="post">
<input type=hidden name=reservation_id value="<%= rs.getString("reservation_id")%>">
<input type="submit" value="예약취소">
</form>
<%
        } else {
            out.println("해당하는 예약 정보가 없습니다.");
        }
    } catch (Exception e) {
        out.println("오류 발생: " + e.getMessage());
    } finally {
        if (rs != null) rs.close();
        if (pstSelect != null) pstSelect.close();
        if (pstUpdate != null) pstUpdate.close();
        if (con != null) con.close();
    }
%>

<!-- 유효성 검사 -->
<script>
    function validateForm() {
        var num_of_guest = document.forms["reservationForm"]["num_of_guest"].value;
        var check_in_date = document.forms["reservationForm"]["check_in_date"].value;
        var check_out_date = document.forms["reservationForm"]["check_out_date"].value;

        // 최대 입실 인원 수 체크
        if (num_of_guest > 11) {
            alert("최대 입실 인원은 11명입니다.");
            return false;
        }

        // 체크아웃 날짜가 체크인 날짜 이후인지 체크
        if (new Date(check_out_date) <= new Date(check_in_date)) {
            alert("체크아웃 날짜는 체크인 날짜 이후여야 합니다.");
            return false;
        }
        return true;
    }
</script>


</body>
</html>