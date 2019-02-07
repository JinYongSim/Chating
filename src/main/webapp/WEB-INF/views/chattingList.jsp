<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function makeRoom(){
		contentOrigin = document.getElementById("login").innerHTML;
		var content = "";
		content += "<h2><a onclick='cancel()'>방 만들기 취소</a></h2>"
		content += "<form action='makeRoom' method='post' id='makeRoomForm'>";
		content += "<input type='hidden' name='userId' value='${sessionScope.loginId}'>";
		content += "<input type='text' name='name'>";
		content += "<input type='button' onclick='check()' value='방만들기'>"
		content += "</form>";
		
		document.getElementById("login").innerHTML=content;
	}
	
	function cancel(){
		document.getElementById("login").innerHTML = contentOrigin;
	}
	function check(){
		document.getElementById("makeRoomForm").submit();
	}
</script>
</head>
<body>
	<div id="login">
		<h2>
			<a onclick="javascript:makeRoom()">방 만들기</a>
		</h2>
	</div>
	<hr>
	<table>
		<tr>
			<td>방제목</td>
			<td>방장</td>
			<td>만든시간</td>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td><a href="entrance?roomSeq=${list.roomSeq}">${list.name}</a></td>
				<td>${list.userId}</td>
				<td>${list.indate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>