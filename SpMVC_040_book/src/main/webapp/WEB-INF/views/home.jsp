<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
</head>
<body>
<h1>내 도서관</h1>
<input name="search">
<input name="st_name">
<button>전송</button>

<script>
document.querySelector("button").addEventListener("click",()=>{
	
	let search = document.querySelector("input[name='search']").value
	let st_name = document.querySelector("input[name='st_name']").value

	// 서버로 fetch(ajax)로 전송하기
	//1. JSON 데이터로 만들기
	let json = { search : search, st_name }
	
	// 2. JSON type의 데이터를 ajax 로 전송하기 위한 문자열 화
	// Serialize 라고 한다
	let jsonString = JSON.stringify(json)
	
	alert(jsonString)
	
	// 3. fetch method를 이용하여 서버로 POST 방식으로 전송하기 
	fetch("${rootPath}/api",{
		method:"POST",
		body : jsonString,
		headers : {
			"content-Type" : "application/json"			
		}
	})
	
	
})



</script>




</body>
</html>