<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
</head>
<body>
	<c:forEach items="${list}" var="bvo">
		<form action="/brd/detail" method="post">
			<div class="card w-75 mb-3">
				<div class="card-body">
					<input type="hidden" name="bno" value="${bvo.bno}">
					<h5 class="card-title">${bvo.title}</h5>
					<button class="btn btn-primary">상세보기</button>
					조회수 : ${bvo.readcount}
				</div>
			</div>
		</form>
	</c:forEach>
	<br>
	<a href="/brd/list?pagenum=0"><button>게시판 목록</button></a>
</body>
</html>