<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<style>
	div#gallery_box {
		width: 90%;
		margin:10px auto;
		border:1px solid #aaa;
		display: flex;
	}
	
	div#gallery_box div:first-of-type {
		flex:1;
		display: flex;
		justify-content: center;
		align-items: center;
		padding:10px;
	}
	div#gallery_box div:last-of-type {
		flex:3;
	}
	div#gallery_files {
		width:90%;
		margin:10px auto;
		display: flex;
		flex-wrap: wrap;;
		border:1px solid blue;
		height: 200px;
	}
	div#gallery_files img {
		margin:2px;
		width: 200px;
	}
	
	div#gallery_botton_box {
		width: 90%;
		margin:5px auto;
		text-align:right;
	}
	
	div#gallery_botton_box button {
		display:inline-block;
		padding:12px 20px;
		outline: 0;
		border: 0;
		border-radius: 10px;
	}
	
	div#gallery_botton_box button:hover {
		box-shadow: 2px 2px 2px #333;
		cursor: pointer;
	}
	
	div#gallery_botton_box button:nth-of-type(1) {
		background-color: blue;
		color:white;
	}
	div#gallery_botton_box button:nth-of-type(2) {
		background-color: red;
		color:yellow;
	}
	
	
</style>
<div id="gallery_box">
	<div>
		<c:if test="${empty GALLERY.g_image}">
			<img src="${rootPath}/files/noImage.png" 
						alt="main_image" width="200px">
		</c:if>
		<c:if test="${not empty GALLERY.g_image}">
			<img src="${rootPath}/files/${GALLERY.g_image}" alt="main_image">
		</c:if>
	</div>
	<div id="gallery_info">
		<h3>제목 : ${GALLERY.g_subject}</h3>
		<h5>SEQ : ${GALLERY.g_seq}</h5>
		<p>작성일 : ${GALLERY.g_date}</p>
		<p>작성시각 : ${GALLERY.g_time}</p>
		<p>작성자 : ${GALLERY.g_writer}</p>
		<p>내용 : ${GALLERY.g_content}</p>
	</div>
</div>


<div id="gallery_files">
	<c:forEach items="${GALLERY.fileList}" var="FILE" >
		<c:if test="${empty FILE.file_upname}">
			<img src="${rootPath}/files/noImage.png" height="100px" >
		</c:if>
		<c:if test="${not empty FILE.file_upname}">
			<img src="${rootPath}/files/${FILE.file_upname}" height="100px" >
		</c:if>
	</c:forEach>
</div>
<div id="gallery_botton_box">
	<button class="gallery update">수정</button>
	<button class="gallery delete">삭제</button>
</div>

<script>
let update_button = document.querySelector("button.gallery.update")
let delete_button = document.querySelector("button.gallery.delete")

update_button.addEventListener("click",()=>{
	// alert("일련번호 ${GALLERY.g_seq} 인 게시물 수정")
	
	/*
	현재 GALLERY.g_seq 값은 숫자형이다
	
	만약 GALLERY.g_seq 값이 S0001 등과 같이 문자열형 이라면
	이 코드는 JS 문법오류가 발생할 것이다
	
	왜 ??
			
	현재 작성한 코드는 JSP 코드이다
	이 코드는 Resonse가 될때 HTML코드로 변환이 되고
	Script부분도 변환이 되는데

	변환되는 과정에서 ${GALLERY.g_seq} 는 담겨있는 문자열인
	S0001 만 단독으로 나타난다
	
	아래 코드는 "/root-context/gallery/update?g_seq=" + S0001 처럼
	변환이 된다
	
	결국 JS 코드가 실행될때 + S0001 처럼 변환되어 변수를 찾게 된다
	그리고 S0001 이라는 변수가 정의 되지 않아
	문법오류가 발생한다
	
	** EL tag를 사용하여
	스크립트 부분에서 직접 값을 부착할때는 DQ("") 부착하여
	문법 오류를 방지하자
	*/
	location.href 
		= "${rootPath}/gallery/update?g_seq=${GALLERY.g_seq}"
		
})

delete_button.addEventListener("click",()=>{
	if(confirm("일련번호 ${GALLERY.g_seq} 인 게시물 삭제 ??")) {
		
		location.replace("${rootPath}/gallery/delete"
				+ "?g_seq=${GALLERY.g_seq}")
		
	}
})


</script>




    
