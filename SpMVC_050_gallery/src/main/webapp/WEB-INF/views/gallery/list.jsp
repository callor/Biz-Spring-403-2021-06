<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<c:set
	var="rootPath"
	value="${pageContext.request.contextPath}" />
<style>
	div.ga_box {
		display: flex;
	}
	div.ga_box div:first-of-type {
		flex:1;
	}
	div.ga_box div:last-of-type {
		flex:3;
	}
</style>

<c:forEach
	items="${GALLERYS}"
	var="GALLERY">
	
	<div class="ga_box">
		<div>
			<img src="${rootPath}/files/${GALLERY.g_image}" width="100px">
		</div>
		<div>
			<h3>${GALLERY.g_subject}</h3>
			<p>${GALLERY.g_content}</p>
		</div>
	</div>

</c:forEach>


