<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body{
        text-align: center;
        background-color: #f1f1f1;
    }
</style>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>EMAIL</th>
			<th>AGE</th>
		</tr>
		<c:forEach items="${list }" var="mvo">
			<tr>
				<td>${mvo.id }</td>
				<td>${mvo.email }</td>
				<td>${mvo.age }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/index.jsp"><button>index</button></a>
</body>
</html>