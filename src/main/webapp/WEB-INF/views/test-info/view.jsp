<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${userInfo.uiNum}
		</tr>
		<tr>
			<th>아이디</th>
			<td>${userInfo.uiId}
		</tr>
		<tr>
			<th>패스워드</th>
			<td>${userInfo.uiPwd}
		</tr>
		<tr>
			<th>이름</th>
			<td>${userInfo.uiName}
		</tr>




	</table>
</body>
</html>