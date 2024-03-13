<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록</title>
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
        String name = request.getParameter("name");
        
        pst = con.prepareStatement("INSERT INTO acorntbl (id, pw, name) VALUES (?, ?, ?)");
        pst.setString(1, id);
        pst.setString(2, pw);
        pst.setString(3, name);
        pst.executeUpdate();
%>

<h2>사용자 등록</h2>
<p>사용자가 성공적으로 등록되었습니다.</p>

<a href="기본페이지.jsp">홈으로 돌아가기</a>
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