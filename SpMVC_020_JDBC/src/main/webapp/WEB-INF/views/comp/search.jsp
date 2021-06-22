<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<style>
	section.search_sec {
		
		/* 
		바깥쪽 box의 position이 fiexd로 되어 있기 때문에
		내부의 box를 바깥 box의 중앙에 배치하기 위하여
		position을 absolute로 설정하고
		위치를 지정하였다
		*/
		position:absolute;
		top:50%;
		left:50%;
		/* 자기 몸체크기의 x, y방향으로 50%만큼 후진 */
		transform:translate(-50%,-50%);
		
		background-color: white;
		opacity:1;
		width: 80%;
		height: 500px;
		display: flex;
		justify-content: center;
		align-content: center;
		
		overflow: auto;
		z-index: 1000;'
		
	}
	section.search_sec table {
		margin:10px auto;
		width:95%;
		opacity:1;
	}
</style>
<body>
	<section class="search_sec">
		<table>
			<tr>
				<th>CODE</th>
				<th>출판사명</th>
				<th>대표</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>주요장르</th>
			</tr>
			<c:choose>
				<c:when test="${empty COMPS}">
					<tr>
						<td cospan="6">데이터가 없음</td>
				</c:when>
				<c:otherwise>
					<c:forEach items="${COMPS}" var="COMP" varStatus="seq">
						<tr>
							<td>${COMP.cp_code}</td>
							<td>${COMP.cp_title}</td>
							<td>${COMP.cp_ceo}</td>
							<td>${COMP.cp_tel}</td>
							<td>${COMP.cp_addr}</td>
							<td>${COMP.cp_genre}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</section>

</body>
<script>
document.querySelector("button.btn_insert.comp")
	.addEventListener("click",()=>{
		location.href = "${rootPath}/comp/insert";
});
</script>

</html>