<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	h1 {
		margin:20px;
		background-color:rgba(0,125,0);
		padding:1rem;
		color:white;
		text-shadow: 1px 1px 1px black;
		
	}
	
	section {
		display: flex;
		flex-wrap: wrap;
		margin-left:20px;
	}
	
	div {
		border:1px solid green;
		flex : 0 1 auto;
		font-size: 30px;
		color:blue;
		margin:10px;
		padding:10px;
	}
	
	a {
		font-size: 30px;
		text-decoration: none;
		margin:20px;
	}
</style>
</head>
<body>
	<h1>화면구현 발표순서</h1>
	<section>
	<c:forEach items="${LIST}" var="VO" varStatus="i"> 
		<div>${VO}</div>
		
	</c:forEach>
	</section>
	<p><a href="${rootPath}/">새로고침</a>
</body>
</html>