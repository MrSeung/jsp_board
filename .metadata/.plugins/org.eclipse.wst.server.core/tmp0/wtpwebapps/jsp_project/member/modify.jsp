<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Modify Page</h1>

	<form action="/mem/modifyDone" method="post">
		<input type="hidden" name="id" value="${mvo.id}">
		<table border="1">
			<tr>
				<th>ID</th>
				<td>${mvo.id}</td>
			</tr>
			<tr>
				<th>PASSWORD</th>
				<td><input type="text" name="password" value="${mvo.password}"></td>
			</tr>
			<tr>
				<th>E-MAIL</th>
				<td><input type="text" name="email" value="${mvo.email}"></td>
			</tr>
			<tr>
				<th>AGE</th>
				<td><input type="text" name="age" value="${mvo.age}"></td>
			</tr>
			<tr>
				<th>REG_DATE</th>
				<td>${mvo.reg_date}</td>
			</tr>
		</table>
		<button type="submit">수정완료</button>
	</form>
	<a href="/mem/delete"><button>회원탈퇴</button></a>
</body>
</html>