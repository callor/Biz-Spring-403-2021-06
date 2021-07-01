<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<c:forEach items="${NEWS_LIST}" var="NEWS">
	<div class="content">
		<div>
			<p class="title">
				<a href="${NEWS.link}" target="_NEW"> ${NEWS.title} </a>
			</p>
			<p class="desc">${NEWS.description}</p>
			<p class="naver">
				<a href="${NEWS.link}" target="_NEW">자세히보기</a>
			</p>
			<p class="origin">
				<a href="${NEWS.originallink}" target="_NEW">언론사바로가기</a>
			</p>
		</div>
	</div>
</c:forEach>
