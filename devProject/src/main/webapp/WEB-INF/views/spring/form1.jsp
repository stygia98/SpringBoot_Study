<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>테스트 : ${message} </h1>

	<h2>Spring Form 입력 화면</h2>
	<!-- modelAttribute 속성에 폼 객체의 속성명을 지정한다. -->
	<form:form modelAttribute="member" method="post" action="/spring/register">
<%-- 	<p> 보이지 않는 id <form:hidden path="userId" /></p> --%>
		<table>
			<tr>
				<td>유저ID</td>
				<td>
					<form:input path="userId" /><font color="red">
					<form:errors path="userId" /></font>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<form:input path="userName" /><font color="red">
					<form:errors path="userName" /></font>
				</td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td>
					<form:password path="password" showPassword="ture"/><font color="red">
					<form:errors path="password" /></font>
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<form:input path="email" /><font color="red">
					<form:errors path="email" /></font>
				</td>
			</tr>
			<tr>
				<td>자기소개</td>
				<td>
					<form:textarea path="introduction" rows="10" cols="22"/><font color="red">
					<form:errors path="introduction" /></font>
				</td>
			</tr>
<%-- 			
			<tr>
				<td>취미</td>
				<td>
					<form:checkboxes path="hobbyValue" items="${member.hobbyList}" itemValue="value" itemLabel="label"/><font color="red">
					<form:errors path="hobbyList" /></font>
				</td>
			</tr> 
--%>
			<tr>
				<td>취미</td>
				<td>
					<form:checkboxes path="hobbyValue" items="${member.hobbyMap}"/><font color="red">
				</td>
			</tr> 
			<tr>
				<td>외국인여부</td>
				<td>
					<form:checkbox path="foreigner" value="false"/><font color="red">
				</td>
			</tr> 
			
			<tr>
				<td>취미</td>
				<td>
					<form:checkbox path="hobbyList2" value="sports" label="sports" />
                    <form:checkbox path="hobbyList2" value="music" label="music" />
                    <form:checkbox path="hobbyList2" value="movie" label="movie" />
				</td>
			</tr> 
			
		</table>
		<form:button name="register">등록</form:button>
	</form:form>

</body>
</html>
