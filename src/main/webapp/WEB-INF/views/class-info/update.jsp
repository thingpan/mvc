<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>강의수정</h3>
<form action="/class-info/update"method="post">
<input type="hidden" name="ciNum"  value="${classInfo.ciNum}">
<input type="test" name="ciName" placeholder="강의명" value="${classInfo.ciName}">
<input type="test" name="ciDesc"placeholder="교수명 " value="${classInfo.ciDesc}">
<button>수정</button>



</form>

</body>
</html>