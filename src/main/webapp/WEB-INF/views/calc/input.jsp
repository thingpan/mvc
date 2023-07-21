<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<br>

	<h3>계산기</h3>
	<form id="frm" action="/calc/p">
		<input type="text" name="num1"> <select
			onchange="changeOp(this)">
			<option value="p">더하기</option>
			<option value="d">빼기</option>
			<option value="n">곱하기</option>
			<option value="d">나누기</option>

		</select>
		 <input type="text" name="num2">
		 <button>계산</button>
	</form>
	<script>
		function changeOp(obj) {
			var action ='/calc/'+obj.value;
			document.getElementById('frm').action=action;
		}
	</script>
</body>
</html>