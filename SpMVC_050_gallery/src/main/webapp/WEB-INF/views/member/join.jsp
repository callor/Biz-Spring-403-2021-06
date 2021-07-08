<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    

<form method="POST">
	<div>
		<label>사용자 ID(Email)</label>
		<input name="m_userid" id="m_userid" type="email">
		<div class="join id">
			
		</div>
	</div>
	<div>
		<label>비밀번호</label>
		<input name="m_password" type="password">
	</div>
	<div>
		<label>비밀번호 확인</label>
		<input name="re_password" type="password">
	</div>
	<div>
		<label>닉네임</label>
		<input name="m_nick">
	</div>
	<div>
		<label>전화번호</label>
		<input name="m_tel" type="tel">
	</div>
	<div>
		<button>가입신청</button>
	</div>
</form>   
<script>
// let user_id = document.querySelector("input#m_userid")
let user_id = document.querySelector("input[name='m_userid']")
let msg_user_id = document.querySelector("div.join.id")

if(user_id) {
	
	user_id.addEventListener("blur",(e)=>{
		let m_userid = e.currentTarget.value
		if(m_userid === "") {
			msg_user_id.innerText = "* 사용자 ID는 반드시 입력하세요"
			msg_user_id.focus()
			return false;
		}
	})
	
}




</script>



 
