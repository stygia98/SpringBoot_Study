<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%> 
<!DOCTYPE html> 
<html> 
<head> 
    <meta charset="UTF-8"> 
    <title>게시판</title> 
    <link rel="stylesheet" href="https://rsms.me/inter/inter.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/resultForm.css">
</head> 
<body> 
	<h1>홈 화면</h1>
	<p>${userInfo.userId}</p>
	<p>${userInfo.userPw}</p>
	
</body> 
</html>