package com.callor.jdbc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/member")
public class MemberController {

	protected final MemberService mService;
	public MemberController(MemberService mService) {
		this.mService = mService;
	}
		
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(
			@RequestParam(name = "MSG",required = false) String msg,
			Model model) {
		
		if(msg == null) {
			model.addAttribute("MSG","NONE");
		} else if(msg.equals("LOGIN")) {
			model.addAttribute("MSG","권한없음 로그인 수행!!!");
		} else if(msg.equals("LOGIN_FAIL")) {
			model.addAttribute("MSG","아이디 비번 확인 !!!");
		}
		return "member/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(
			@RequestParam("m_username") String username, 
			@RequestParam("m_password") String password,
			HttpSession hSession, Model model) {
		
		log.debug("사용자ID {} " , username);
		log.debug("비밀번호 {} " , password);
		
		UserVO userVO = mService.login(username, password);
		
		// 로그인 실패했을 경우
		if(userVO == null) {
			model.addAttribute("MSG","LOGIN_FAIL");
			return "redirect:/member/login";
		}
		
		
		/*
		 * HttpSession 객체는 한번 생성되면
		 * 유효기간 동안 서버의 메모리에 상주한다
		 * Session 꼭 필요한 경우에만 최소한으로 생성하는 것이 좋다
		 */
		hSession.setAttribute("USERVO", userVO);
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession hSession) {
		
		// 로그인된 세션 삭제하기
		hSession.removeAttribute("USERVO");
		hSession = null;
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		return "member/join";
	}
	
	
}
