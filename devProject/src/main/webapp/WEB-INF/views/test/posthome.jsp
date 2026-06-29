<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 	<form action="/test/gohome1" method="post">
		userId: <input type="text" name="userId" value="hong"><br>
		password: <input type="text" name="password" value="1234"><br>
		coin: <input type="text" name="coin" value="100"><br>
		<input type="submit" value="/test/gohome1">
	</form> 
-->
	
	<form action="/test/gohome1" method="post">
		boardNo: <input type="text" name="boardNo" value="1"><br>
		title: <input type="text" name="title" value="test title1"><br>
		content: <input type="text" name="content" value="test content1"><br>
		writer: <input type="text" name="writer" value="test writer1"><br>
		coin: <input type="text" name="coin" value="10000"><br>
		<input type="submit" value="/test/gohome1">
	</form>
	
</body>
</html>