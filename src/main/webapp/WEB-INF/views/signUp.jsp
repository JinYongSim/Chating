<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check(){
		document.getElementById("signUpForm").submit();
	}
</script>
</head>
<body>
	<form action="signUp" method="post" id="signUpForm">
		아이디 : <input type="text" name="userId">
		비밀번호 : <input type="text" name="userPw">
		<input type="button" value="등록" onclick="check()">
	</form>
</body>
</html>