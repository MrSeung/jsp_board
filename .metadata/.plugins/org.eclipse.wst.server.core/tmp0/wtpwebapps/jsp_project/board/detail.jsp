<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
	<form action="/brd/go_modify" method="post">
		<input type="hidden" name="bno" value="${bvo.bno}"> writer :
		${bvo.writer}<br> <br> title : ${bvo.title}<br> <br>
		content : ${bvo.content}<br>
		<c:if test="${bvo.image_file ne '' && bvo.image_file ne null}">
		<img alt="없음" src="/_fileUpload/${bvo.image_file}">
		</c:if>
		<br> reg_date : ${bvo.reg_date}<br>
		<br> <a href="/brd/list?pagenum=0"><button type="button">목록으로</button></a>
		<c:if test="${ses.id eq bvo.writer}">
			<button>수정하기</button>
			<a href="/brd/remove?bno=${bvo.bno}"><button type="button">삭제</button></a>
			<br>
		</c:if>
		<hr>
	</form>
	
		<input type="hidden" id="bno" value="${bvo.bno}"> 
		<input type="hidden" id="id" value="${ses.id}">
		<textarea rows="5" cols="50" id=reText></textarea>
		<button type="button" id="reAddBtn">댓글작성</button>
	<hr>

	<div class="accordion" id="accordionExample">
	</div>
	
	<script src="/resources/board_reply.js"></script>
	<script type="text/javascript">
		const bnoVal=`<c:out value="${bvo.bno}"/>`;
		const user=`<c:out value="${ses.id}" />`
		printReplyList(bnoVal);
	</script>
	
	
	
	<!-- 리셋 해줘야함... 계속 누점됨... -->
	<!--
	<c:forEach items="${re_list}" var="list">
		<h4>${list.user_id}</h4>
		<h5>${list.content }</h5>
		<h6>${list.reg_date }</h6>
		<c:if test="${ses.id eq list.user_id}">

			<a href="/re/remove?rno=${list.rno}"><button type="button">삭제</button></a>
		</c:if>
		<hr>
	</c:forEach>

	-->
</body>
</html>