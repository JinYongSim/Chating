<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check(){
		document.getElementById("loginForm").submit();
	}
</script>
</head>
<body>
	<h1>로그인</h1>
	<form action="login" id="loginForm">
	아이디 : <input type="text" name="userId">
	비밀번호 : <input type="text" name="userPw">
	<input type="button" value="로그인하기" onclick="check()">
	</form>
	<p>${loginErrorMessage}</p>
</body>
</html>