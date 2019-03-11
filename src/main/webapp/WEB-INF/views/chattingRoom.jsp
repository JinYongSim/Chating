<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
function check(){
	document.getElementById("insertMessageForm").submit();
}
setInterval(
function ajaxTest(){
	$.ajax({
			url : "selectChat",
			data : {roomSeq : ${room.roomSeq}},
			type : "get",
			success : function(data){
				var context="";
				
				document.getElementById("contents").innerHTML=context
			}
			
	});
}
)
</script>
</head>
<body>
	<h1>${room.name}</h1>
	<button onclick="ajaxTest()">ajaxTest</button>
	<div id="contents"></div>
	<hr>
		<table>
			<c:forEach var="cList" items="${cList}">
				<tr>
					<td>${cList.userId } : </td>
					<td>${cList.message }</td>
					<td>${cList.indate }</td>
				</tr>
			</c:forEach>
		</table>
		
	<hr>
	<form action="insertMessage" method="post" id="insertMessageForm">
		<input type="hidden" name="roomSeq" value="${room.roomSeq}">
		<input type="text" name="message">
		<input type="button" value="전송" onclick="check()">
	</form>
	
</body>
</html>