<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서정보 관리 2021</title>
<style>
	* {
		box-sizing: border-box;
		margin:0;
		padding:0;
	}
	
	section#main_sec {
		width:100%;
		margin:5px auto;
		border:1px solid #999;
		
		display: flex;
		
	}
	section#main_sec article {
		flex : 1;
		border:1px solid green;
		margin: 6px 3px;
		padding:5px;
	}
	
	section#main_sec article ul,section#main_sec article ol {
		margin:0;
		padding:0;
	}

	section#main_sec article li {
		margin:0 20px;
		padding:0 5px;
	}
	
	section#ad_sec {
		width:100%;
		bordre:1px solid #999;
	}
	
	section#ad_sec article {
		height:100px;
		margin:6px 3px;
		background:url("${rootPath}/static/images/ad.png") no-repeat;
		background-size:100% 100%; /* cover */
		border-radius: 5px;
	}

	
</style>
</head>
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
		<article>
		
		</article>
	</section>
	
	
	<%@ include file="/WEB-INF/views/include/include_footer.jspf" %>
	
</body>
</html>