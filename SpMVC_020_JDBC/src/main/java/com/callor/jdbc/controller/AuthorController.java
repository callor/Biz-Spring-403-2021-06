package com.callor.jdbc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.service.AuthorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/author")
public class AuthorController {

	protected final AuthorService auService;
	public AuthorController(AuthorService auService) {
		this.auService = auService;
	}
	
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String list(HttpSession hSession, Model model) {
		
		UserVO userVO = (UserVO)hSession.getAttribute("USERVO");
		if(userVO == null) {
			model.addAttribute("MSG","LOGIN");
			return "redirect:/member/login";
		}
		List<AuthorVO> auList = auService.selectAll();
		log.debug("저자정보: {}", auList.toString());
		
		/*
		 * Attribute를 지정할때 흔히 저지르는 실수
		 * Att의 이름은 문자열 형태이기 때문에 어떠한 기호를 사용해도
		 * 무방하다
		 * 하지만
		 * jsp에서 랜더링할때는 이 Attr문자열이 변수로 취급이 된다
		 * 변수로 취급된다는 것은
		 * java의 일반적인 코딩 규칙이 적용된다는 것이다
		 * 
		 * 작성할때는 비록 문자열이지만, 변수명명규칙에 맞도록
		 * 이름을 작성해야 한다
		 * 그렇지 않으면 jsp에서 오류를 만나게 될것이다
		 * 
		 */
		model.addAttribute("AUTH_LIST",auList);
		
		return "author/list";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "author/input";
	}
	
}
