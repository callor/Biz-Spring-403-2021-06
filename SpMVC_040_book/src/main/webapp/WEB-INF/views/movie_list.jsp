<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<c:forEach items="${MOVIES}" var="MOVIE">
	<div class="content">
		<img src="${MOVIE.image}">
		<div>
			<p class="title">
				<a href="${MOVIE.link}" target="_NEW"> ${MOVIE.title} </a>
			</p>
			<p class="desc">${MOVIE.description}</p>
			<p class="author">
				<strong>저자 : </strong>${MOVIE.author}
			</p>
			<p class="publisher">
				<strong>출판사 : </strong>${MOVIE.publisher}
			</p>
			<button class="insert">내 서재등록</button>
		</div>
	</div>
</c:forEach>
