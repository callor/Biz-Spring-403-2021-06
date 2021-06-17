package com.callor.jdbc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.model.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/author")
public class AuthorController {

	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String list(HttpSession hSession, Model model) {
		
		UserVO userVO = (UserVO)hSession.getAttribute("USERVO");
		if(userVO == null) {
			model.addAttribute("MSG","LOGIN");
			return "redirect:/member/login";
		}
		return "author/list";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "author/input";
	}
	
}
