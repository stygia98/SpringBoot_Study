<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Model Attribute 데이터 전송 테스트</h1>
	<p>member : ${member.userId}</p>
	<p>member : ${member.password}</p>
	<p>member : ${member.userName}</p>
	<p>member : ${member.email}</p>
	
	
	<c:forEach var="member" items="${list}">
		member : <c:out value="${member.userId}"></c:out>
		<p>member : ${member.password}</p>
		<p>member : ${member.userName}</p>
		<p>member : ${member.email}</p>
	</c:forEach>
 
</body>
</html>
