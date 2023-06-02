<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/brd/modify" method="post" enctype="multipart/form-data">
	<input type="hidden" name="bno" value="${bvo.bno}">
	writer : ${bvo.writer}<br><br>
	title : <input type="text" name=title placeholder="${bvo.title}"><br><br>
	content : <input type="text" name=content placeholder="${bvo.content}"><br><br>
	image_file : <img alt="없음" src="/_fileUpload/${bvo.image_file}">
	
	
	<input type="hidden" name="image_file" value="${bvo.image_file }">
	<input type="file" name="new_file"><br><br>
	reg_date : ${bvo.reg_date}<br><br>
	<button>수정완료</button>
	</form>
</body>
</html>