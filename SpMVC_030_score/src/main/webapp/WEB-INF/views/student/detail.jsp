<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
	form input {
		width:50%;
	}
</style>    
<form>
<c:forEach items="${SSLIST}" var="SS">
	<div>
		<input name="subject" value="${SS.ss_code}" hidden="hidden">
		<label>${SS.ss_stname}</label>
		<input name="score" value="${SS.ss_score }">
	</div>
</c:forEach>
</form>