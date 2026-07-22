<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h3>로그아웃</h3>
	<form action="/logout" method="post">
		<sec:csrfInput />
		<button>로그아웃</button>
	</form>

</body>
</html>
