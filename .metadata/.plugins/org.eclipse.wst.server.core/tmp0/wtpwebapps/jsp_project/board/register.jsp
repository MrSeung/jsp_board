<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/brd/register" method="post" enctype="multipart/form-data">
	<input type="hidden" name="writer" value="${ses.id}">
	작성자 : ${ses.id}<br>
	제목 : <input type="text" name="title"><br>
	내용 : <textarea rows="10" cols="10" name="content"></textarea>	<br>
	이미지 파일 : <input type="file" id="file" name="image_file" accept="image/png, image/jpg, image/jpeg, image/bmp, image/gif"> <br>
	<button>작성완료</button>
</form>
	
</body>
</html>