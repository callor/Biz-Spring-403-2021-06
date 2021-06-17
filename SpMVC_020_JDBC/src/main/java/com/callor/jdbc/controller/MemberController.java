package com.callor.jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/member")
public class MemberController {

	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(
			@RequestParam("m_username") String username, 
			@RequestParam("m_password") String password) {
		
		log.debug("사용자ID {} " , username);
		log.debug("비밀번호 {} " , password);
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		return "member/join";
	}
	
	
}
