<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 수정</h3>
<form action="/user-info/update"method="post">
<input type ="hidden" name="uiNum" value="${userInfo.uiNum }">
<input type ="test" name="uiId" placeholder="아이디" value="${userInfo.uiId}"><br>
<input type ="password" name="uiPwd" placeholder="비밀번호" ><br>
<input type ="test" name="uiName" placeholder="이름" value="${userInfo.uiName}"><br>
<button>수정</button>

</form>
</body>
</html>