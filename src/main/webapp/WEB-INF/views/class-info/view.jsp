<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/class-info/delete" method="POST">
	<input type="hidden" name="ciNum" value="${classInfo.ciNum}">
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${classInfo.ciNum}
		</tr>
		      <th>강의명</th>
				<td>${classInfo.ciName}
		</tr>
				<th>교수명</th>
				<td>${classInfo.ciDesc}
			</tr>
				<tr>
			<th colspan="2">
				<button onclick="location.href='/class-info/update?ciNum=${classInfo.ciNum}'" type="button">수정</button>
				<button>삭제</button>
			</th>
		</tr>
	</table>
</body>
</html>