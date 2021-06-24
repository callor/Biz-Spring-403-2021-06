<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" cotent="width=device-width, initial-scale:1"/>	
<title>나의 홈페이지</title>
</head>
<style>
*  {
	box-sizing: border-box;
	margin:0;
	padding:0;
}
body {
	width:100wv;
	height:100vh;
	display: flex;
	flex-direction: column;	
}
header {
	
	background: url("${rootPath}/static/images/header_backgroud.jpg") no-repeat;
	background-size: 100% 50%;
	background-position: top ;
	background-attachment: fixed;
	
	text-align: center;
	text-shadow:1px 1px 1px black;
	color:white;
	padding:2rem;
	
}

section#main_sec {
	flex:1;
	width: 100wv;
	display: flex;
	flex-direction: column;
	background: url("${rootPath}/static/images/section_background.jpg") no-repeat;
	background-size: 100% 100%;
	background-attachment: fixed;
	
}

table {
	border: 0;
	width:90%;
	border-collapse: collapse;
	border-spacing: 0;
	margin:10px auto;
}

tr {
	border-top: 1px solid green;
}

tr:last-child {
	border-bottom: 1px solid green;
}

tr:nth-of-type(odd) {
	background-color: #ccc;
}

tr:nth-of-type(even) {
	background-color: #eee;
}

tr:hover td {
	background-color: #aaa;
	cursor: pointer;
}


td, th {
	border-right: 1px solid green;
	padding:8px 12px;
	text-align: center;
}

td.number {
	text-align: right;
}
td:last-child, th:last-child {
	border:none;
}

div.btn_box {
	width:90%;
	/* 
	table의 margin:10px auto로 설정되어 있기 때문에
	top margin 은 0으로 bottom margin은 10px 좌우는 auto
	*/ 
	margin: 0px auto 10px auto;
	padding:5px;
	text-align: right;
}

div.btn_box button {
	border:0;
	outline: 0;
	padding:12px 16px;
	margin-left:10px;
	border-radius: 5px;
}

button:hover {
	box-shadow: 2px 2px 2px 2px black;
	cursor: pointer;
} 

</style>
<body>
	<header>
		<h1>대한고교 성적처리</h1>
		<p>대한고교 성적처리 시스템 2021</p>
	</header>
	<section id="main_sec">
		<c:choose>
			<c:when test="${ BODY == 'SCORE_VIEW' }">
				<%@ include file="/WEB-INF/views/score/list.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/views/main.jsp"%>
			</c:otherwise>
		</c:choose>
	</section>
</body>
<script>
document.querySelector("button.student.insert")
	.addEventListener("click",(e)=>{
		location.href = "${rootPath}/student"
})
</script>

</html>