<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
<link href="${rootPath}/static/css/main.css" ref="stylesheet" />
<style>
	h1, form {
		width:80%;
		margin:0 auto;
	}
	label, input {
		padding:8px;
		margin:3px;
	}

	label {
		display: inline-block;
		width:20%;
		text-align: right;
	}
	
	input  {
		display: inline-block;
		width:70%;
	}
	
</style>
</head>
<body>
	<h1>나의 홈페이지에 오신것을 환영합니다</h1>
	<%--
	form에 네이버, 다음, 구글 검색 URL을 action으로 지정하고
	input 의 name 속성에 각 검색용 query 변수명을 사용하면
	input 에 검색어를 입력한 후 Enter를 누르면
	각 검색 사이트에 데이터를 전송하고 결과를 화면에 보여준다
	
	action 값이 http:// 또는 https:// 로 시작되는 경우는
	현재의 localhost에 요청을 보내는 것이 아니고
	외부의 URI(URL)로 전송을 하게 된다.
	 --%>
	<form action="https://search.naver.com/search.naver">
		<label>네이버 검색</label><input name="query">
	</form>
	<form action="https://search.daum.net/search">
		<label>다음 검색</label><input name="q">
	</form>
	<form action="https://www.google.com/search">
		<label>구글 검색</label><input name="q">
	</form>

</body>
</html>