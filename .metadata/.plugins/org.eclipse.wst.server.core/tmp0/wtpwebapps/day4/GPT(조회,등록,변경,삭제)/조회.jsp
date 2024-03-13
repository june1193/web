<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 조회</title>
</head>
<body>

<%
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:testdb";
    String user = "scott";
    String password = "tiger";
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    try {
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, password);
        
        pst = con.prepareStatement("SELECT * FROM acorntbl");
        rs = pst.executeQuery();
%>

<h2>사용자 조회</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>비밀번호</th>
        <th>이름</th>
    </tr>
<%
        while (rs.next()) {
%>
    <tr>
        <td><%= rs.getString("id") %></td>
        <td><%= rs.getString("pw") %></td>
        <td><%= rs.getString("name") %></td>
    </tr>
<%
        }
%>
</table>

<%
    } catch (Exception e) {
        out.println("오류 발생: " + e.getMessage());
    } finally {
        if (rs != null) rs.close();
        if (pst != null) pst.close();
        if (con != null) con.close();
    }
%>

</body>
</html>