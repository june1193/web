<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <title>환영 메시지</title>
</head>
<body>
    <h1>환영합니다, <%= request.getAttribute("name") %>님!</h1>
</body>
</html>