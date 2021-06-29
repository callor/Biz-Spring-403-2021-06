<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" cotent="width=device-width, initial-scale:1" />
<title>나의 홈페이지</title>
</head>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body {
	width: 100wv;
	height: 100vh;
	display: flex;
	flex-direction: column;
}

header {
	background: url("${rootPath}/static/images/header_backgroud.jpg")
		no-repeat;
	background-size: 100% 50%;
	background-position: top;
	background-attachment: fixed;
	text-align: center;
	text-shadow: 1px 1px 1px black;
	color: white;
	padding: 2rem;
}

nav {
	background-color: black;
	color: white;
	width: 100wv;
	transision:1s;
}

/*
nav.fixed {
	position: fixed;
	top: 0;
	left: 0;
	right: 10px;
	border-bottom-right-radius: 20px;
	box-shadow: 3px 3px 3px rgba(0, 0, 0, 0.5);
}
*/

nav ul {
	list-style: none;
	display: flex;
	margin: 0 20px;
}

nav li {
	padding: 16px 12px;
	border-bottom: 3px solid transparent;
	transition: 0.5s;
	cursor: pointer;
}

nav li:hover {
	border-bottom: 3px solid yellow;
}

nav li:nth-of-type(2) {
	margin-left: auto;
}

section#main_sec {
	flex: 1;
	width: 100wv;
	display: flex;
	flex-direction: column;
	background: linear-gradient(to bottom, transparent, mistyrose),
		url("${rootPath}/static/images/section_background.jpg");
	background-size: 100% 100%;
	background-attachment: fixed;

	/*
	header와 nav를 화면에 고정하고
	data가 보이는 부분만 scoll 하기 위하여
	section#main_sec에 overflow 속성 부여하기
	
	*/
	overflow: auto;
}

h2 {
	width: 90%;
	color: white;
	margin: 10px auto 0 auto;
	padding: 1rem;
	border: 1px solid #aaa;
}

table {
	border: 0;
	width: 90%;
	border-collapse: collapse;
	border-spacing: 0;
	margin: 10px auto;
}

tr {
	border-top: 1px solid green;
}

tr:last-child {
	border-bottom: 1px solid green;
}

tr:nth-of-type(odd) {
	background-color: #ccc;
}

tr:nth-of-type(even) {
	background-color: #eee;
}

tr:hover td {
	background-color: #aaa;
	cursor: pointer;
}

td, th {
	border-right: 1px solid green;
	padding: 8px 12px;
	text-align: center;
}

td.number {
	text-align: right;
}

td:last-child, th:last-child {
	border: none;
}

div.btn_box {
	width: 90%;
	/* 
	table의 margin:10px auto로 설정되어 있기 때문에
	top margin 은 0으로 bottom margin은 10px 좌우는 auto
	*/
	margin: 0px auto 10px auto;
	padding: 5px;
	text-align: right;
}

div.btn_box button {
	border: 0;
	outline: 0;
	padding: 12px 16px;
	margin-left: 10px;
	border-radius: 5px;
}

button:hover {
	box-shadow: 2px 2px 2px 2px black;
	cursor: pointer;
}

button.save {
	background-color: blue;
	color: white;
}

button.reset {
	background-color: olive;
	color: white;
}

button.list {
	background-color: green;
	color: white;
}

button.home {
	background-color: black;
	color: white;
	text-shadow: 1px 1px 1px black;
}

button.insert {
	background-color: rgba(0, 0, 200, 1);
	color: white;
}

button.update {
	background-color: green;
	color: white;
}

button.delete {
	background-color: red;
	color: yellow;
}

button.student.list {
	background-color: orange;
	color: white;
	text-shadow: 1px 1px 1px black;
}

form {
	width: 90%;
	margin: 0 auto 10px auto;
}

fieldset {
	background-color: #eee;
	border: 1px solid green;
	border-radius: 10px;
	padding: 0.7rem;
}

form label, form input {
	display: inline-block;
	margin: 5px;
	padding: 8px 16px;
}

form label {
	width: 30%;
	text-align: right;
	color: blue;
	font-weight: bold;
}

form input {
	width: 60%;
	outline: 0;
	border: #aaa;
	border-radius: 50px;
}

form input:hover {
	background: #bbb;
}
</style>
<body>
	<header>
		<h1>대한고교 성적처리</h1>
		<p>대한고교 성적처리 시스템 2021</p>

	</header>
	<nav id="main_nav">
		<ul>
			<li>HOME</li>
			<li>로그인</li>
			<li>로그아웃</li>
			<li>관리자</li>
		</ul>
	</nav>


	<section id="main_sec">
		<c:choose>
			<c:when test="${ BODY == 'SCORE_VIEW' }">
				<%@ include file="/WEB-INF/views/score/list.jsp"%>
			</c:when>
			<c:when test="${BODY == 'STUDENT_LIST'}">
				<%@ include file="/WEB-INF/views/student/list.jsp"%>
			</c:when>
			<c:when test="${BODY == 'STUDENT_INPUT' }">
				<%@ include file="/WEB-INF/views/student/input.jsp"%>
			</c:when>
			<c:when test="${BODY == 'STUDENT_DETAIL' }">
				<%@ include file="/WEB-INF/views/student/detail.jsp"%>
			</c:when>

			<c:otherwise>
				<%@ include file="/WEB-INF/views/main.jsp"%>
			</c:otherwise>
		</c:choose>
	</section>
</body>
<script>
/*
   JS 코드에서 event를 등록할때 현재 화면에 없는 DOM 요소에
   addEvent를 설정하면 없는 함수라는 오류가 발생한다
   그이유는 현재 화면에 없는 DOM 요소를 querySelecor하면
   그 결과값이 null 이기 때문에 발생하는 문제이다
   
   JS 코드를 통합하여 모음으로 관리할때는
   addEvent를 하려고 하는 요소가 있는지를 먼저 검사한 후
   addEvnet를 수행해 주어야 한다.
 */
let std_list = document.querySelector("button.student.list");
let std_insert = document.querySelector("button.student.insert");
let home = document.querySelector("button.student.home") 

// std_list가 있으면
if(std_list) {
	std_list.addEventListener("click",(e)=>{
			location.href = "${rootPath}/student"
	})
}
if(std_insert) {
	std_insert.addEventListener("click",(e)=>{
			location.href = "${rootPath}/student/insert"
	})
}


if(home) {
	home.addEventListener("click",(e)=>{
			location.href = "${rootPath}/"
	})
	
}


let table = document.querySelector("table.detail")
if(table) {
	table.addEventListener("click",(e)=>{

		let target = e.target
		let tagName = target.tagName
		if(tagName === "TD") {
			let tr = target.closest("TR")
			let stNum = tr.dataset.stnum
			location.href 
			= "${rootPath}/student/detail?st_num=" + stNum
		}
	})
}

let main_nav = document.querySelector("nav#main_nav")
let main_header = document.querySelector("header")

// header box의 높이가 얼마냐
let main_header_height = main_header.offsetHeight;

document.addEventListener("scroll",()=>{

	// HTML 문서 전체의 크기, 좌표 등을 추출하기
	let doc_bound = document.querySelector("HTML")
				.getBoundingClientRect();
	
	let doc_top = doc_bound.top

	/*
	화면이 아래방향으로 스크롤될때
	화면 문서의 top 좌표를 추출하여
	
	header box의 높이와 비교
	header box의 높이에 -1을 곱하고 그 값보다 작아지면
	==  header box가 화면에서 사라지면
	nav에 fixed 라는 class를 부착하고
	== header box가 화면에서 나타나면
	nav에 fixed class를 제거하여 원래 모습으로 다시 보이기
	*/
	if(doc_top < main_header_height * -1) {
		main_nav.classList.add("fixed")
	} else {
		main_nav.classList.remove("fixed")
	}
})





</script>

</html>