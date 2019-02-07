<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<c:if test="${sessionScope.loginId==null }">
	<form action="goSignUp">
		<input type="submit" value="회원가입">
	</form>

	<form action="goLogin">
		<input type="submit" value="로그인">
	</form>
</c:if>
<c:if test="${sessionScope.loginId!=null }">
	<form action="goChattingList">
		<input type="submit" value="채팅방목록 입장">
	</form>
	<form action="logout">
		<input type="submit" value="로그아웃">
	</form>
</c:if>
</body>
</html>
