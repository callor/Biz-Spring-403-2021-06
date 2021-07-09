<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    


<style>
	div.msg.view {
		color:yellow;
		background-color: red;
		font-size: 20px;
		padding: 1rem;
		border-radius: 20px;
	}
</style>


<form method="POST" id="login_form">
	<div class="msg login error">
	</div>
	<div>
		<label>사용자 ID</label>
		<input name="m_userid" type="email">
	</div>
	<div>
		<label>비밀번호</label>
		<input name="m_password" type="password"/>
	</div>
	<div>
		<button type="button" class="login">로그인</button>
		<button type="button" class="join">회원가입</button>
	</div>
</form>
<script>

let form = document.querySelector("#login_form")
let btn_login = document.querySelector("button.login")
let btn_join = document.querySelector("button.join")
let msg_error = document.querySelector("div.msg.login.error")

let input_userid = document.querySelector("input[name='m_userid']")
let input_password = document.querySelector("input[name='m_password']")

if(btn_login) {
	
	btn_login.addEventListener("click",()=>{
		
		let m_userid = input_userid.value
		let m_password = input_password.value
		if(m_userid === "") {
			alert("사용자 ID는 필수입력 항목입니다 !!!")
			input_userid.focus()
			return false
		}
		if(m_password === "") {
			alert("비밀번호는 필수입력 항목입니다 !!!")
			input_password.focus()
			return false
		}
		form.submit()
	})
}

if(btn_join) {
	btn_join.addEventListener("click",()=>{
		location.href="${rootPath}/member/join"
	})
}

let login_fail = "${LOGIN_FAIL}"

if(login_fail === "NOT_USERID") {
	
	msg_error.innerText = "사용자 ID가 없습니다!!!"
	msg_error.classList.add("view")
	
	// msg_error.style.fontSize = "20px"
	// msg_error.style.backgroundColor = "red"
	// msg_error.style.padding = "2rem"
	
} else if(login_fail === "NEQ_PASS") {

	msg_error.innerText = "비밀번호가 틀렸습니다!!!"
	msg_error.classList.add("view")
		
	// msg_error.style.fontSize = "20px"
	// msg_error.style.backgroundColor = "red"
	// msg_error.style.padding = "2rem"
	
} else if(login_fail === "LOGIN_REQ") {
	
	msg_error.innerHTML = "로그인이 필요한 서비스 입니다<br/>";
	msg_error.innerHTML += "로그인을 해 주세요";
	msg_error.classList.add("view")
	
}

</script>
    


