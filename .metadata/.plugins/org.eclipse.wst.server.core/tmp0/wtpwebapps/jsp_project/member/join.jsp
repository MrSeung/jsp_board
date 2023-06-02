<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Castoro+Titling&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
        }

        form {
            background-color: #ffffff;
            border: 1px solid #ccc;
            margin: 50px auto;
            padding: 30px;
            padding-top: 50px;
            width: 500px;
            box-shadow: 0 0 10px #ccc;
            /* border-radius: 10px; */
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
            /* color: #777; */
            color: black;
        }

        input[type="text"]{
            padding: 10px;
            width: 95%;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 20px;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: black;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            width: 200px;
        }

        input[type="submit"]:hover {
            background-color: gray;
        }
        #btn-join{
            text-align: center;
            margin-top: 20px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
	<form action="/mem/register" method="post">
		<!-- 
		id : <input type="text" name="id" placeholder="ID"><br><br>
		password : <input type="text" name="password" placeholder="PW"><br><br>
		email : <input type="text" name="email" placeholder="E-mail"><br><br>
		age : <input type="text" name="age" placeholder="Age"><br><br>
		<button type="submit">가입완료</button>
		
		 -->
		<h3>회원가입</h3> <br>
        <label for="email">아이디:</label>
        <input type="text" id="id" name="id" required>
        <label for="password">비밀번호:</label>
        <input type="text" id="password" name="password" required>
        <label for="email">이메일:</label>
        <input type="text" id="email" name="email" required>
        <label for="name">나이:</label>
        <input type="text" id="age" name="age" required>
        <div id="btn-join">
            <input type="submit" value="회원가입">
        </div>
	</form>
</body>
</html>