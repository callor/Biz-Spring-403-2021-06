<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
    
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
<body>
	<%@ include file="/WEB-INF/views/include/inlude_header.jspf" %>
	<section id="main_sec">
		<article>
			<h3>출판사</h3>
			<ol>
				<li>출판사정보</li>
				<li>출판사정보</li>
				<li>출판사정보</li>
				<li>출판사정보</li>
				<li>출판사정보</li>
			</ol>	
		</article>
		<article>
			<h3>도서정보</h3>
			<ul>
				<li>도서정보</li>
				<li>도서정보</li>
				<li>도서정보</li>
				<li>도서정보</li>
				<li>도서정보</li>
			</ul>	
		</article>
		<article>
			<h3>저자정보</h3>
			<ul>
				<li>저자정보</li>
				<li>저자정보</li>
				<li>저자정보</li>
				<li>저자정보</li>
				<li>저자정보</li>
			</ul>
		</article>
	</section>
	<section id="ad_sec">
		<article></article>
		<article></article>
		<article></article>
		<article></article>
		<article></article>
	</section>
	
	
	<%@ include file="/WEB-INF/views/include/include_footer.jspf" %>
	
</body>
</html>