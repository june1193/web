<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>합계산</title>
</head>
<body>
    <% int sum = 0;
       for (int i = 1; i <= 10; i++) {
           sum += i;
       }
    %>
    <p>1부터 10까지의 합: <%= sum %></p>
</body>
</html>