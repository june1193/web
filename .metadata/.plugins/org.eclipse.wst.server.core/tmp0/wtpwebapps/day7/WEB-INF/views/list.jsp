<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    
<%@page import="java.util.ArrayList" %>
<%@page import="day7.Acorn" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 <link href="/day7/css/list.css"  type="text/css"  rel="stylesheet" >
</head>
<body>

<table>
	<tr>
		<td>���̵�</td>
		<td>���</td>
		<td>�̸�</td>
	</tr>
	<%ArrayList<Acorn> list = (ArrayList<Acorn>) request.getAttribute("list"); 
	
		for(Acorn acorn : list){
	%>
	<tr>
		<td><%=acorn.getId() %></td>
		<td><%=acorn.getPw() %></td>
		<td><%=acorn.getName() %></td>
	</tr>
	
	<%} %>
</table>

</body>
</html>