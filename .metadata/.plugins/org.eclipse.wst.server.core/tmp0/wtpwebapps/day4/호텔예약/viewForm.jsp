<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 조회 페이지</title>
</head>
<body>

<h2>예약 조회</h2>

<form action="updatedeleteForm.jsp" method="post">
    <label for="reservation_id">예약번호:</label>
    <input type="text" id="reservation_id" name="reservation_id"><br><br>
    
    <label for="customer_id">손님번호:</label>
    <input type="text" id="customer_id" name="customer_id"><br><br>
    
    <input type="submit" value="조회">
</form>

</body>
</html>