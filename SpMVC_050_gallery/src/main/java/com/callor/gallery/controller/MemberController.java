package com.callor.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.gallery.model.MemberVO;
import com.callor.gallery.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	protected final MemberService memService;
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("BODY","JOIN");
		return "home";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(MemberVO memberVO, Model model) {
		log.debug("회원가입 정보 {}", memberVO.toString());
		
		memberVO = memService.join(memberVO);
		
		model.addAttribute("BODY","JOIN");
		return "home";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/id_check",method=RequestMethod.GET)
	public String id_check(String m_userid) {
		
		log.debug("중복 검사를 수행할 ID: {}", m_userid);
		MemberVO memberVO =memService.findById(m_userid);
		
		if(memberVO == null) {
			return "NOT_USE_ID";
		} else {
			return "USE_ID";
		}
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("BODY","LOGIN");
		return "home";
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(MemberVO memberVO, Model model) {
		
		memberVO = memService.login(memberVO, model);
		if(memberVO == null) {
			model.addAttribute("BODY","LOGIN");
			return "home";			
		} else {

			
			return "redirect:/";
		}

	}

	
	
	
}



