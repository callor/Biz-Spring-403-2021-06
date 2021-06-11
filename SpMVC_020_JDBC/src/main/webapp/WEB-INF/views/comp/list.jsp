<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
    
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
<body>
	<%@ include file="/WEB-INF/views/include/inlude_header.jspf" %>
	<h1 class="page_title">출판사정보</h1>
	<table>
		<tr>
			<th>CODE</th>
			<th>출판사명</th>
			<th>대표</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>주요장르</th>
		</tr>
		<tr>
			<td>CODE</td>
			<td>출판사명</td>
			<td>대표</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>주요장르</td>
		</tr>
	</table>
	
	<div class="btn_box">
		<button class="btn_insert comp">출판사등록</button>
	</div>
	
	<%@ include file="/WEB-INF/views/include/include_footer.jspf" %>

</body>
<script>
document.querySelector("button.btn_insert.comp")
	.addEventListener("click",()=>{
		location.href = "${rootPath}/comp/insert";
});
</script>

</html>