<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<style>
</style>
<body>
	<%@ include file="/WEB-INF/views/include/inlude_header.jspf"%>
	<section class="main_sec">
		<table>
			<tr>
				<th>ISBN</th>
				<th>도서명</th>
				<th>출판사</th>
				<th>저자</th>
				<th>출판연도</th>
				<th>가격</th>
				<th>페이지수</th>
			</tr>

			
			<tr>
				<td>ISBN</td>
				<td>도서명</td>
				<td>출판사</td>
				<td>저자</td>
				<td>출판연도</td>
				<td>가격</td>
				<td>페이지수</td>
			</tr>
		</table>

		<div class="btn_box">
			<button class="btn_insert book">도서등록</button>
		</div>
	</section>

	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>

</body>
<script>
document.querySelector("button.btn_insert.book")
	.addEventListener("click",()=>{
		location.href = "${rootPath}/books/insert";
});
</script>

</html>