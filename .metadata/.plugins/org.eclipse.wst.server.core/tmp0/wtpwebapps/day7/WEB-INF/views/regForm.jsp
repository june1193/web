<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
table{
	border:1px solid black;
	width:300px;
	margin:0 auto;
	border-collapse:collapse;
}

td{
border:1px solid black;
text-align: center;
}
</style>

</head>
<body>



<form name="frm" action="/day7/reg" method="post">
<table>
	<caption>������ �л����</caption>
	<tr>
		<td>���̵�</td>
		<td><input type="text" name="id"></td>
	</tr>
	
	<tr>
		<td>��й�ȣ</td>
		<td><input type="text" name="pw"></td>
	</tr>
	
	<tr>
		<td>�̸�</td>
		<td><input type="text" name="name"></td>
	</tr>
	
	<tr>
		<td colspan="2">
		<button type="submit">���</button>
		<button type="reset">���</button>
		</td>
	</tr>

</table>

</form>
</body>
</html>