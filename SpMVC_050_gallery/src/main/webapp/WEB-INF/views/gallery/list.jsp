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

section#image_list_section {
	width: 90vw;
	margin: 20px auto;
	display: flex;
	flex-wrap: wrap;
}

div.gallery_box {
	flex: 1 0 30%;
	display: flex;
	border: 1px solid blue;
	padding: 1rem;
	margin: 1rem;
	border-radius: 10px;
	box-shadow: 5px 5px 5px 3px rgba(0, 0, 0, 0.3);
}

div.gallery_box div:first-of-type {
	flex: 1;
}

div.gallery_box div:last-of-type {
	flex: 3;
}

@media ( max-width :1500px) {
	div.gallery_box {
		flex: 1 45%;
	}
}

@media ( max-width :1000px) {
	div.gallery_box {
		flex: 1 0 100%;
	}
}
</style>
<%@ include file="/WEB-INF/views/include/include_gallery_search.jspf" %>
<section id="image_list_section">
<c:forEach
	items="${GALLERYS}"
	var="GALLERY">

	<div class="gallery_box">
		<div>
			<c:if test="${empty GALLERY.g_image}">
				<img
					src="${rootPath}/files/noImage.png"
					width="100px">
			</c:if>
			<c:if test="${not empty GALLERY.g_image}">
				<img
					src="${rootPath}/files/${GALLERY.g_image}"
					width="100px">
			</c:if>
		</div>
		<div>
			<h3>
				<a href="${rootPath}/gallery/detail2/${GALLERY.g_seq}">
					${GALLERY.g_subject}( ${GALLERY.g_seq} ) </a>
			</h3>
			<p>${GALLERY.g_content}</p>
		</div>
	</div>

</c:forEach>
</section>
<%@ include file="/WEB-INF/views/include/include_page_nav.jspf"%>






