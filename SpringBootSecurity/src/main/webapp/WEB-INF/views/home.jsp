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
	<h1>메인 페이지</h1>
	<P>서버의 시간은 ${serverTime} 입니다.</P>
	<a href="/board/list">회원 게시판</a>
	<br>
	<a href="/notice/list">공지사항</a>
</body>
</html>