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
	<form action="/test/gohome1" method="post" enctype="multipart/form-data">
		<input type="file" name="picture"><br>
		<input type="file" name="picture"><br>
		<input type="submit" value="/test/gohome1">
	</form>
	
<!-- 
	<form action="/test/gohome1" method="post">
		userId: <input type="text" name="userId" value="hong"><br>
		password: <input type="text" name="password" value="1234"><br>
		coin: <input type="text" name="coin" value="100"><br>
		<input type="submit" value="/test/gohome1">
	</form> 
	<hr>
	<form action="/test/gohome1" method="post">
		boardNo: <input type="text" name="boardNo" value="1"><br>
		title: <input type="text" name="title" value="test title1"><br>
		content: <input type="text" name="content" value="test content1"><br>
		writer: <input type="text" name="writer" value="test writer1"><br>
		coin: <input type="text" name="coin" value="10000"><br> <input
			type="submit" value="/test/gohome1">
	</form>
	<hr>
	<form action="/test/gohome1" method="post">
		gender <br> <input type="radio" name="gender" value="male"	checked> 
		Male<br> <input type="radio" name="gender" value="female"> 
		Female<br> <input type="radio" name="gender" value="other"> 
		Other<br> <input type="submit" value="registerRadio">
	</form>
	<hr>
	<form action="/test/gohome1" method="post"> 
		nationality<br>
			<select name="nationality" multiple>
				<option value="Korea" selected>대한민국</option>
				<option value="Germany">독일</option>
				<option value="Australia">호주</option>
				<option value="Canada">캐나다</option>
			</select><br>
		<input type="submit" value="/test/gohome1">
	</form>
	<hr>
	<form action="/test/gohome1" method="post"> 
		hobby<br>
			<input type="checkbox" name="hobby" value="Sports" checked> Sports<br>
			<input type="checkbox" name="hobby" value="Music"> Music<br>
			<input type="checkbox" name="hobby" value="Movie"> Movie<br>
			<input type="submit" value="registerCheckbox01">
	</form>
	<hr>
	<form action="/test/gohome1" method="post">
		foreigner
			<input type="checkbox" name="foreigner"><br>
			<input type="submit" value="registerCheckbox05">
	</form>
	<hr>
	<form action="/test/gohome1" method="get">
		postCode: <input type="text" name="address[0].postCode" /><br> 
		location: <input type="text" name="address[0].location" /><br>
		postCode: <input type="text" name="address[1].postCode" /><br> 
		location: <input type="text" name="address[1].location" /><br>
	<input type="submit" value="registerAddress">
	</form>
-->	

</body>
</html>