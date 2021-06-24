<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
	button.score.insert {
		background-color: rgba(0,0,200,1);
		color:white;
	}
	
	button.score.student {
		background-color: orange;
		color:white;
	}

</style>
<table>
	<tr>
		<th>학번</th>
		<th>학생이름</th>
		<th>CD</th>
		<th>과목명</th>
		<th>점수</th>
	<tr>
		<c:choose>
			<c:when test="${empty SCORES}">
				<tr>
					<td colspan="5">데이터가 없음</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${SCORES}" var="SCORE">
					<tr>
						<td>${SCORE.sc_stnum}</td>
						<td>${SCORE.sc_stname}</td>
						<td>${SCORE.sc_sbcode}</td>
						<td>${SCORE.sc_sbname}</td>
						<td class="number">${SCORE.sc_score}</td>
				</c:forEach>
			</c:otherwise>
		</c:choose>
</table>
<div class="btn_box">
	<button class="score insert">성적등록</button>
	<button class="score student insert">학생정보 바로가기</button>
</div>



