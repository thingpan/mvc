<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>난 강의 리스트</h3>

	<table border="1">
		<tr>

			<th>번호</th>
			<th>강의명</th>
			<th>교수명</th>


		</tr>
		<c:forEach items="${classInfoList}" var="classInfo">
			<tr>
				<td>${classInfo.ciNum}</td>
				<td>${classInfo.ciName}</td>
			<td><a href="/class-info/view?uiNum=${classInfo.ciNum}">${classInfo.ciDesc}</a></td>
			</tr>
		</c:forEach>
		<tr>
		<td align="right" colspan="3"><button onclick ="location.href='/class-info/insert'">등록</button>
		</tr>


	</table>
</body>
</html>