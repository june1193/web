<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�հ��</title>
</head>
<body>
    <% int sum = 0;
       for (int i = 1; i <= 10; i++) {
           sum += i;
       }
    %>
    <p>1���� 10������ ��: <%= sum %></p>
</body>
</html>