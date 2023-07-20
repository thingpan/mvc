<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>난 강의 리스트</h3>
	<%=request.getAttribute("classInfoList")%>
	<table border="1">
		<tr>

			<th>번호</th>
			<th>강의명</th>
			<th>교수명</th>
			<%
			for (Map<String, String> map : classInfoList) {
			%>
		
		<tr>
			<th><%=map.get("ciNum")%></th>
			<th><%=map.get("ciName")%></th>


			<th><a href="/class-info/view?ciNum?=<%=map.get("ciNum")%>"><%=map.get("ciDesc")%></a></th>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>