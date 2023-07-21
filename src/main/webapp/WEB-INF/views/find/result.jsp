<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>결과</h3>
정답<%=request.getAttribute("msg") %>
갯수<%=request.getAttribute("c") %>
</body>
</html>