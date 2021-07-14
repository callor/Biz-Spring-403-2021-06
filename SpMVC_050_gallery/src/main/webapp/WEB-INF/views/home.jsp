<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
<script src="https://kit.fontawesome.com/58b5d9133d.js" crossorigin="anonymous"></script>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body {
	height: 100vh;
	width: 100%;
	display: flex;
	flex-direction: column;
}

header {
	padding: 2rem;
	color: white;
	text-shadow: 2px 2px 2px black;
	text-align: center;
	background: url("${rootPath}/static/images/header.jpg") repeat;
	background-size: 100% 100%;
	background-position: 0 0;
	height: 50vh;
}




form {
	width: 95%;
	margin: 10px auto;
	border: 1px solid green;
	padding: 12px 16px;
}

form label, form input, form textarea {
	margin: 5px;
	padding: 8px;
}

form label {
	display: inline-block;
	width: 30%;
	text-align: right;
	margin-right: 5px;
	font-weight: bold;
	color: blue;
}

form input, form textarea {
	display: inline-block;
	width: 60%;
}

form button {
	margin: 10px;
	padding: 0.7rem 2rem;
	outline: 0;
	border: 0;
	background-color: blue;
	color: white;
	border-radius: 10px;
}

form button:hover {
	box-shadow: 2px 2px 2px 2px rgba(0, 0, 0, 0.7);
}
</style>
</head>
<body>
<header>
	<h1>내 갤러리</h1>
</header>
<%@ include file="/WEB-INF/views/include/include_nav.jspf" %>
<c:choose>
	<c:when test="${BODY eq 'GA-INPUT'}">
		<%@ include file="/WEB-INF/views/gallery/input.jsp" %>
	</c:when>
	<c:when test="${BODY eq 'GA-LIST'}">
		<%@ include file="/WEB-INF/views/gallery/list.jsp" %>
		<a href="${rootPath}/gallery/input">이미지 등록</a>
	</c:when>
	<c:when test="${BODY eq 'GA-DETAIL'}">
		<%@ include file="/WEB-INF/views/gallery/detail.jsp" %>
	</c:when>
	
	<c:when test="${BODY eq 'GA-DETAIL-V2'}">
		<%@ include file="/WEB-INF/views/gallery/detail2.jsp" %>
	</c:when>

	<c:when test="${BODY eq 'JOIN'}">
		<%@ include file="/WEB-INF/views/member/join.jsp" %>
	</c:when>

	<c:when test="${BODY eq 'LOGIN'}">
		<%@ include file="/WEB-INF/views/member/login.jsp" %>
	</c:when>


	<c:otherwise>
		<a href="${rootPath}/gallery/input">이미지 등록</a>
	</c:otherwise>
</c:choose>

<c:forEach items="${FILES}" var="FILE">
	<a href="${rootPath}/files/${FILE}" target="_NEW">
	<img 
		src="${rootPath}/files/${FILE}" 
		width="100px" height="100px"/>
	</a>
</c:forEach>


</body>
<script>
let main_nav = document.querySelector("nav#main_nav")

if(main_nav) {
	
	main_nav.addEventListener("click",(e)=>{
		let menu = e.target
		if(menu.tagName === "LI") {
			
			if(menu.id === "join") {
				location.href = "${rootPath}/member/join"
			} else if(menu.id === "login") {
				location.href = "${rootPath}/member/login/nav"
			} else if(menu.id === "logout") {
				location.href = "${rootPath}/member/logout"
			} else if(menu.id === "image_create") {
				location.href = "${rootPath}/gallery/input"
			} else if(menu.id === "home") {
				location.href ="${rootPath}/"
			}
		}
	})
	
}



</script>





</html>