<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date"%>
<% /* scriptlet */
	Date date = new Date();
	String serverTime2 = date.toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더 파일 시작 -->
	<%@ include file="./../includes/header.jsp"%>
	<p>서버에서 보내준 데이터를 출력 ${serverTime}</p>
	<p>서버에서 보내준 데이터를 출력 <%= serverTime2 %></p>
	<!-- 푸터 파일 시작 -->
	<%@ include file="./../includes/footer.jsp"%>
</body>
</html>