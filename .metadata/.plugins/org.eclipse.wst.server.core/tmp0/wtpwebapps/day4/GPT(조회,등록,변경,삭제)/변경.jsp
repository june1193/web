<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 변경</title>
</head>
<body>

<%
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:testdb";
    String user = "scott";
    String password = "tiger";
    
    Connection con = null;
    PreparedStatement pst = null;
    
    try {
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, password);
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        
        pst = con.prepareStatement("UPDATE acorntbl SET pw=? WHERE id=?");
        pst.setString(1, pw);
        pst.setString(2, id);
        pst.executeUpdate();
%>

<h2>비밀번호 변경</h2>
<form method="post" action="기본페이지.jsp" >
    ID: <%= id %><br>
    새 비밀번호: <input type="password" name="pw"><br>
     <input type="hidden" name="id" value="<%= id %>"><br>
       <input type="hidden" name="action"  value="update"><br>
    <input type="submit" value="확인">
    
</form>

<%
    } catch (Exception e) {
        out.println("오류 발생: " + e.getMessage());
    } finally {
        if (pst != null) pst.close();
        if (con != null) con.close();
    }
%>

</body>
</html>