<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
	form#student_detail input {
		
	}
	table.student_detail th, table.student_datail td {
		border-top:#333;
		border-bottom: #eee;
		border-right: #333;
		border-left: #aaa;
		
		border:1px solid;
		border-spacing: 1px;
	}
	
	table.student_detail th {
		width:15;
	}
	
	table.student_detail td {
		width:30%;
	}
</style>

<table class="student_detail">
	<tr>
		<th>학번</th><td>${STD.st_num}</td>
		<th>이름</th><td>${STD.st_name}</td>
	</tr>
	<tr>
		<th>학과</th><td>${STD.st_dept}</td>
		<th>학년</th><td>${STD.st_grade}</td>
	</tr>
	<tr>
		<th>전화번호</th><td>${STD.st_tel}</td>
		<th>주소</th><td>${STD.st_addr}</td>
	</tr>
</table>   
<div class="btn_box">
	<button class="student update">수정</button>
	<c:if test="${SC_COUNT < 1}">
		<button class="student delete">삭제</button>
	</c:if>
</div>

<form id="student_detail" method="POST">
<fieldset>
<c:forEach items="${SSLIST}" var="SS">
	<div>
		<label>${SS.ss_stname}</label>
		<input name="subject" value="${SS.ss_code}"  type="hidden">
		<input name="score" value="${SS.ss_score }">
	</div>
</c:forEach>
	<div class="btn_box">
		<button type="submit" class="save">저장</button>
		<button type="button" class="list">리스트로</button>
		<button type="button" class="student home">처음으로</button>
	</div>
	</fieldset>
</form>



